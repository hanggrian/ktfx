package ktfx.jfoenix

import ktfx.layouts.NodeManager
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutToolkitTest
import ktfx.test.assertContains

class JFXScrollPaneTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        val top1 = jfxButton()
        val mid1 = jfxButton()
        val mid2 = jfxButton()
        val bottom1 = jfxButton()
        val bottom2 = jfxButton()
        val bottom3 = jfxButton()
        val main1 = jfxButton()
        val condensed1 = jfxButton()
        val condensed2 = jfxButton()
        val pane = jfxScrollPane {
            topBar {
                addNode(top1)
            }
            midBar {
                addNode(mid1)
                addNode(mid2)
            }
            bottomBar {
                addNode(bottom1)
                addNode(bottom2)
                addNode(bottom3)
            }
            mainHeader {
                addNode(main1)
            }
            condensedHeader {
                addNode(condensed1)
                addNode(condensed2)
            }
        }
        assertContains(pane.topBar.children, top1).inOrder()
        assertContains(pane.midBar.children, mid1, mid2).inOrder()
        assertContains(pane.bottomBar.children, bottom1, bottom2, bottom3).inOrder()
        assertContains(pane.mainHeader.children, main1).inOrder()
        assertContains(pane.condensedHeader.children, condensed1, condensed2).inOrder()
    }
}
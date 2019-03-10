package ktfx.jfoenix

import ktfx.test.ToolkitLayoutTest
import ktfx.test.assertContains

class JFXScrollPaneTest : ToolkitLayoutTest() {

    override fun newInstance() {
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
                top1.add()
            }
            midBar {
                mid1.add()
                mid2.add()
            }
            bottomBar {
                bottom1.add()
                bottom2.add()
                bottom3.add()
            }
            mainHeader {
                main1.add()
            }
            condensedHeader {
                condensed1.add()
                condensed2.add()
            }
        }
        assertContains(pane.topBar.children, top1).inOrder()
        assertContains(pane.midBar.children, mid1, mid2).inOrder()
        assertContains(pane.bottomBar.children, bottom1, bottom2, bottom3).inOrder()
        assertContains(pane.mainHeader.children, main1).inOrder()
        assertContains(pane.condensedHeader.children, condensed1, condensed2).inOrder()
    }

    override fun withManager() {
    }
}
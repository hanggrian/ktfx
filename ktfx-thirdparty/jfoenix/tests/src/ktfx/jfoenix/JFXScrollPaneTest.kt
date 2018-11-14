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
                top1()
            }
            midBar {
                mid1()
                mid2()
            }
            bottomBar {
                bottom1()
                bottom2()
                bottom3()
            }
            mainHeader {
                main1()
            }
            condensedHeader {
                condensed1()
                condensed2()
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
package ktfx.jfoenix

import com.google.common.truth.Truth
import ktfx.test.ToolkitLayoutTest

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
        Truth.assertThat(pane.topBar.children).containsExactly(top1).inOrder()
        Truth.assertThat(pane.midBar.children).containsExactly(mid1, mid2).inOrder()
        Truth.assertThat(pane.bottomBar.children).containsExactly(bottom1, bottom2, bottom3).inOrder()
        Truth.assertThat(pane.mainHeader.children).containsExactly(main1).inOrder()
        Truth.assertThat(pane.condensedHeader.children).containsExactly(condensed1, condensed2).inOrder()
    }

    override fun withManager() {
    }
}
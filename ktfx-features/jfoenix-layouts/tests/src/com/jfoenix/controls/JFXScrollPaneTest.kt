package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXScrollPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import ktfx.test.assertContains
import kotlin.test.Test

class JFXScrollPaneTest : BaseLayoutTest<NodeManager, JFXScrollPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxScrollPane { }
    override fun NodeManager.child2() = jfxScrollPane()
    override fun NodeManager.child3() = jfxScrollPane { }

    @Test fun barAndHeader() {
        jfxScrollPane {
            val top1: JFXButton
            val mid1: JFXButton
            val mid2: JFXButton
            val bottom1: JFXButton
            val bottom2: JFXButton
            val bottom3: JFXButton
            val main1: JFXButton
            val condensed1: JFXButton
            val condensed2: JFXButton
            jfxScrollPane {
                topBar {
                    top1 = jfxButton()
                }
                midBar {
                    mid1 = jfxButton()
                    mid2 = jfxButton()
                }
                bottomBar {
                    bottom1 = jfxButton()
                    bottom2 = jfxButton()
                    bottom3 = jfxButton()
                }
                mainHeader {
                    main1 = jfxButton()
                }
                condensedHeader {
                    condensed1 = jfxButton()
                    condensed2 = jfxButton()
                }
                assertContains(topBar.children, top1).inOrder()
                assertContains(midBar.children, mid1, mid2).inOrder()
                assertContains(bottomBar.children, bottom1, bottom2, bottom3).inOrder()
                assertContains(mainHeader.children, main1).inOrder()
                assertContains(condensedHeader.children, condensed1, condensed2).inOrder()
            }
        }
    }
}
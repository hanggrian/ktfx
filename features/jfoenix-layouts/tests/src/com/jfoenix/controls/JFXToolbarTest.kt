package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXToolbar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import ktfx.test.assertContains
import kotlin.test.Test

class JFXToolbarTest : BaseLayoutTest<NodeManager, JFXToolbar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxToolbar { }
    override fun NodeManager.child2() = jfxToolbar()
    override fun NodeManager.child3() = jfxToolbar { }

    @Test fun leftAndRightItems() {
        val left1: JFXButton
        val right1: JFXButton
        val right2: JFXButton
        jfxToolbar {
            leftItems {
                left1 = jfxButton()
            }
            rightItems {
                right1 = jfxButton()
                right2 = jfxButton()
            }
            assertContains(leftItems, left1).inOrder()
            assertContains(rightItems, right1, right2).inOrder()
        }
    }
}
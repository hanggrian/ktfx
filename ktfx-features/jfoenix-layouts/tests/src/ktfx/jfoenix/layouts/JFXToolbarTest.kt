package ktfx.jfoenix.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutToolkitTest
import ktfx.test.assertContains

class JFXToolbarTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        val left1 = jfxButton()
        val right1 = jfxButton()
        val right2 = jfxButton()
        val toolbar = jfxToolbar {
            leftItems {
                addChild(left1)
            }
            rightItems {
                addChild(right1)
                addChild(right2)
            }
        }
        assertContains(toolbar.leftItems, left1).inOrder()
        assertContains(toolbar.rightItems, right1, right2).inOrder()
    }
}
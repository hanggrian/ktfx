package ktfx.jfoenix

import ktfx.test.ToolkitLayoutTest
import ktfx.test.assertContains

class JFXToolbarTest : ToolkitLayoutTest() {

    override fun newInstance() {
        val left1 = jfxButton()
        val right1 = jfxButton()
        val right2 = jfxButton()
        val toolbar = jfxToolbar {
            leftItems {
                left1()
            }
            rightItems {
                right1()
                right2()
            }
        }
        assertContains(toolbar.leftItems, left1).inOrder()
        assertContains(toolbar.rightItems, right1, right2).inOrder()
    }

    override fun withManager() {
    }
}
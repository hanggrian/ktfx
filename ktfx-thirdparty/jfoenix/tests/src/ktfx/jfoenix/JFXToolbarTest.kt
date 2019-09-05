package ktfx.jfoenix

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.ToolkitLayoutTest
import ktfx.test.assertContains

class JFXToolbarTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            val left1 = jfxButton()
            val right1 = jfxButton()
            val right2 = jfxButton()
            val toolbar = jfxToolbar {
                leftItems {
                    left1.add()
                }
                rightItems {
                    right1.add()
                    right2.add()
                }
            }
            assertContains(toolbar.leftItems, left1).inOrder()
            assertContains(toolbar.rightItems, right1, right2).inOrder()
        }
    }
}
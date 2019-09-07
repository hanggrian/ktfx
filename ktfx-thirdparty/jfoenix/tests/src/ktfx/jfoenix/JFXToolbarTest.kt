package ktfx.jfoenix

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.LayoutToolkitTest
import ktfx.test.assertContains

class JFXToolbarTest : LayoutToolkitTest<NodeManager>(_Pane()) {

    override fun NodeManager.layout() {
        val left1 = jfxButton()
        val right1 = jfxButton()
        val right2 = jfxButton()
        val toolbar = jfxToolbar {
            leftItems {
                addNode(left1)
            }
            rightItems {
                addNode(right1)
                addNode(right2)
            }
        }
        assertContains(toolbar.leftItems, left1).inOrder()
        assertContains(toolbar.rightItems, right1, right2).inOrder()
    }
}
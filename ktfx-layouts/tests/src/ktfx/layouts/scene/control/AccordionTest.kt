package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.test.ToolkitLayoutTest

class AccordionTest : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            /*accordion {
                assertEmpty(panes)
                label("Hello")
                "World" {
                    label("haha")
                }
                assertEquals(2, panes.size)
                assertTrue(panes[1].content is Label)
            }*/
        }
    }
}
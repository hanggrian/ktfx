package ktfx.layouts.scene.layout

import javafx.scene.paint.Color.RED
import ktfx.layouts.NodeManager
import ktfx.layouts._Pane
import ktfx.layouts.label
import ktfx.layouts.textFlow
import ktfx.test.ToolkitLayoutTest
import kotlin.test.assertEquals

class TextFlowTes : ToolkitLayoutTest<NodeManager>(_Pane()) {

    override fun test() {
        manage {
            textFlow {
                label("Hello")
                "World" {
                    fill = RED
                    assertEquals(fill, RED)
                }

                assertEquals(children.size, 2)
            }
        }
    }
}
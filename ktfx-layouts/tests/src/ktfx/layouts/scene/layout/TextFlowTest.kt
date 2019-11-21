package ktfx.layouts.scene.layout

import javafx.scene.paint.Color.RED
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.textFlow
import ktfx.testing.LayoutToolkitTest
import kotlin.test.assertEquals

class TextFlowTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        textFlow {
            "World" {
                fill = RED
                assertEquals(fill, RED)
            }
            assertEquals(children.size, 1)
        }
    }
}
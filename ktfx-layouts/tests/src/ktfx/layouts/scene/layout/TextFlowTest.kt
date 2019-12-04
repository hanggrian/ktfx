package ktfx.layouts.scene.layout

import javafx.scene.paint.Color
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.textFlow
import ktfx.test.LayoutToolkitTest
import kotlin.test.assertEquals

class TextFlowTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        textFlow {
            "World" {
                fill = Color.RED
                assertEquals(fill, Color.RED)
            }
            assertEquals(children.size, 1)
        }
    }
}
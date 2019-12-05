package ktfx.layouts.scene.text

import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.textFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest : LayoutTest<NodeManager, TextFlow>() {

    override fun createManager() = KtfxPane()
    override fun create() = textFlow { }
    override fun NodeManager.add() = textFlow()
    override fun NodeManager.addWithBuilder() = textFlow { }

    @Test fun stringInvocation() {
        textFlow {
            "World" {
                fill = Color.RED
                assertEquals(fill, Color.RED)
            }
            assertEquals(children.size, 1)
        }
    }
}
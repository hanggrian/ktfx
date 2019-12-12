package ktfx.layouts.scene.text

import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.textFlow
import ktfx.test.BaseLayoutTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest : BaseLayoutTest<NodeManager, TextFlow>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = textFlow { }
    override fun NodeManager.child2() = textFlow()
    override fun NodeManager.child3() = textFlow { }

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
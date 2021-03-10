package ktfx.layouts

import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest : LayoutsTest<KtfxPane, TextFlow>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = textFlow { }
    override fun KtfxPane.child2() = textFlow()
    override fun KtfxPane.child3() = textFlow { }

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
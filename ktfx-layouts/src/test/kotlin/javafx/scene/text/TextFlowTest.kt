package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest : LayoutsTest<KtfxPane, TextFlow>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): TextFlow = textFlow { }

    override fun KtfxPane.child2(): TextFlow = textFlow()

    override fun KtfxPane.child3(): TextFlow = textFlow { }

    @Test
    fun stringInvocation() {
        textFlow {
            "World" {
                fill = Color.RED
                assertEquals(fill, Color.RED)
            }
            assertEquals(children.size, 1)
        }
    }
}

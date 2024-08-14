package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.paint.Color
import javafx.scene.text.TextFlow
import kotlin.test.Test
import kotlin.test.assertEquals

class TextFlowTest : LayoutsStyledTest<KtfxPane, TextFlow>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = textFlow {}

    override fun KtfxPane.child2() = textFlow()

    override fun child3() = styledTextFlow(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTextFlow(styleClass = arrayOf("style"))

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

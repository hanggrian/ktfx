package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Rectangle
import kotlin.test.assertEquals

class RectangleTest : LayoutsStyledTest<KtfxPane, Rectangle>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = rectangle {}

    override fun KtfxPane.child2() = rectangle()

    override fun child3() = styledRectangle(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledRectangle(styleClass = arrayOf("style"))

    override fun Rectangle.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}

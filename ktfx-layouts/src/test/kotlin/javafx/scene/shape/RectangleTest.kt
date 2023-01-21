package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Rectangle
import kotlin.test.assertEquals

class RectangleTest : LayoutsTest<KtfxPane, Rectangle>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): Rectangle = rectangle { }
    override fun KtfxPane.child2(): Rectangle = rectangle()
    override fun KtfxPane.child3(): Rectangle = rectangle { }

    override fun Rectangle.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}

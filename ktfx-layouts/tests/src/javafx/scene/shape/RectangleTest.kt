package ktfx.layouts

import javafx.scene.shape.Rectangle
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class RectangleTest : LayoutsTest<KtfxPane, Rectangle>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = rectangle { }
    override fun KtfxPane.child2() = rectangle()
    override fun KtfxPane.child3() = rectangle { }

    override fun Rectangle.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}

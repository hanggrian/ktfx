package ktfx.layouts

import javafx.scene.shape.Rectangle
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class RectangleTest : BaseLayoutTest<NodeManager, Rectangle>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = rectangle { }
    override fun NodeManager.child2() = rectangle()
    override fun NodeManager.child3() = rectangle { }

    override fun Rectangle.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}
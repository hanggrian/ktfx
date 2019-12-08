package ktfx.layouts.scene.shape

import javafx.scene.shape.Rectangle
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.rectangle
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class RectangleTest : LayoutTest<NodeManager, Rectangle>() {

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
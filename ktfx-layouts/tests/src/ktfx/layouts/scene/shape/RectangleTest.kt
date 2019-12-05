package ktfx.layouts.scene.shape

import javafx.scene.shape.Rectangle
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.rectangle
import kotlin.test.assertEquals

class RectangleTest : LayoutTest<NodeManager, Rectangle>() {

    override fun createManager() = KtfxPane()
    override fun create() = rectangle { }
    override fun NodeManager.add() = rectangle()
    override fun NodeManager.addWithBuilder() = rectangle { }

    override fun Rectangle.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}
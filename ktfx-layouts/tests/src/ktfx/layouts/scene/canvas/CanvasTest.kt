package ktfx.layouts.scene.canvas

import javafx.scene.canvas.Canvas
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.canvas
import kotlin.test.assertEquals

class CanvasTest : LayoutTest<NodeManager, Canvas>(KtfxPane()) {

    override fun create() = canvas { }
    override fun NodeManager.add() = canvas()
    override fun NodeManager.addWithBuilder() = canvas { }

    override fun Canvas.testDefaultValues() {
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}
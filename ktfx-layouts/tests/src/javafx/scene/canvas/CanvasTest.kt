package ktfx.layouts

import javafx.scene.canvas.Canvas
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class CanvasTest : LayoutsTest<NodeManager, Canvas>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = canvas { }
    override fun NodeManager.child2() = canvas()
    override fun NodeManager.child3() = canvas { }

    override fun Canvas.testDefaultValues() {
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}
package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.canvas.Canvas
import kotlin.test.assertEquals

class CanvasTest : LayoutsTest<KtfxPane, Canvas>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Canvas = canvas { }

    override fun KtfxPane.child2(): Canvas = canvas()

    override fun KtfxPane.child3(): Canvas = canvas { }

    override fun Canvas.testDefaultValues() {
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}

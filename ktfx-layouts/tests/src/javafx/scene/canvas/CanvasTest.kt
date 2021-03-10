package ktfx.layouts

import javafx.scene.canvas.Canvas
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class CanvasTest : LayoutsTest<KtfxPane, Canvas>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = canvas { }
    override fun KtfxPane.child2() = canvas()
    override fun KtfxPane.child3() = canvas { }

    override fun Canvas.testDefaultValues() {
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}
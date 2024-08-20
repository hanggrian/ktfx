package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.canvas.Canvas
import kotlin.test.assertEquals

class CanvasTest : LayoutsStyledTest<KtfxPane, Canvas>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = canvas {}

    override fun KtfxPane.child2() = canvas()

    override fun child3() = styledCanvas()

    override fun KtfxPane.child4() = styledCanvas()

    override fun Canvas.testDefaultValues() {
        assertEquals(0.0, width)
        assertEquals(0.0, height)
    }
}

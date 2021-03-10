package ktfx.layouts

import javafx.scene.shape.Ellipse
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class EllipseTest : LayoutsTest<KtfxPane, Ellipse>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = ellipse { }
    override fun KtfxPane.child2() = ellipse()
    override fun KtfxPane.child3() = ellipse { }

    override fun Ellipse.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
    }
}
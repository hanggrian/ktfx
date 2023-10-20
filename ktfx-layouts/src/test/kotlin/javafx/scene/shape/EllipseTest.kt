package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Ellipse
import kotlin.test.assertEquals

class EllipseTest : LayoutsTest<KtfxPane, Ellipse>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Ellipse = ellipse { }

    override fun KtfxPane.child2(): Ellipse = ellipse()

    override fun KtfxPane.child3(): Ellipse = ellipse { }

    override fun Ellipse.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
    }
}

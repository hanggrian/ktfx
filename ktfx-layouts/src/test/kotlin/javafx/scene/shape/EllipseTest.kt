package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Ellipse
import kotlin.test.assertEquals

class EllipseTest : LayoutsStyledTest<KtfxPane, Ellipse>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = ellipse {}

    override fun KtfxPane.child2() = ellipse()

    override fun child3() = styledEllipse(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledEllipse(styleClass = arrayOf("style"))

    override fun Ellipse.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
    }
}

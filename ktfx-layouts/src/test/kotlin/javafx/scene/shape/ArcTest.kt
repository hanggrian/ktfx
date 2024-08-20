package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Arc
import kotlin.test.assertEquals

class ArcTest : LayoutsStyledTest<KtfxPane, Arc>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = arc {}

    override fun KtfxPane.child2() = arc()

    override fun child3() = styledArc()

    override fun KtfxPane.child4() = styledArc()

    override fun Arc.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, startAngle)
        assertEquals(0.0, length)
    }
}

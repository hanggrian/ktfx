package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Arc
import kotlin.test.assertEquals

class ArcTest : LayoutsTest<KtfxPane, Arc>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Arc = arc { }

    override fun KtfxPane.child2(): Arc = arc()

    override fun KtfxPane.child3(): Arc = arc { }

    override fun Arc.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, startAngle)
        assertEquals(0.0, length)
    }
}

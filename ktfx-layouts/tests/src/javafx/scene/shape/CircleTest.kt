package ktfx.layouts

import javafx.scene.shape.Circle
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircleTest : LayoutsTest<KtfxPane, Circle>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = circle { }
    override fun KtfxPane.child2() = circle()
    override fun KtfxPane.child3() = circle { }

    override fun Circle.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radius)
        assertNull(fill)
    }
}
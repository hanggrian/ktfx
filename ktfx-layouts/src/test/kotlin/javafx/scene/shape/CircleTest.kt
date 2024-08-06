package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Circle
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircleTest : LayoutsTest<KtfxPane, Circle>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Circle = circle { }

    override fun KtfxPane.child2(): Circle = circle()

    override fun KtfxPane.child3(): Circle = circle { }

    override fun Circle.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radius)
        assertNull(fill)
    }
}

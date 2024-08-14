package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Circle
import kotlin.test.assertEquals
import kotlin.test.assertNull

class CircleTest : LayoutsStyledTest<KtfxPane, Circle>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = circle {}

    override fun KtfxPane.child2() = circle()

    override fun child3() = styledCircle(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCircle(styleClass = arrayOf("style"))

    override fun Circle.testDefaultValues() {
        assertEquals(0.0, centerX)
        assertEquals(0.0, centerY)
        assertEquals(0.0, radius)
        assertNull(fill)
    }
}

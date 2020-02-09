package ktfx.layouts

import javafx.scene.shape.Cylinder
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class CylinderTest : LayoutsTest<KtfxPane, Cylinder>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = cylinder { }
    override fun KtfxPane.child2() = cylinder()
    override fun KtfxPane.child3() = cylinder { }

    override fun Cylinder.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(2.0, height)
        assertEquals(64, divisions)
    }
}
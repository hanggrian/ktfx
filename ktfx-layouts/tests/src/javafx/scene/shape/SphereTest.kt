package ktfx.layouts

import javafx.scene.shape.Sphere
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class SphereTest : LayoutsTest<KtfxPane, Sphere>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = sphere { }
    override fun KtfxPane.child2() = sphere()
    override fun KtfxPane.child3() = sphere { }

    override fun Sphere.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(64, divisions)
    }
}
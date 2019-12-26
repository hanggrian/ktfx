package ktfx.layouts

import javafx.scene.shape.Sphere
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class SphereTest : LayoutTest<NodeManager, Sphere>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = sphere { }
    override fun NodeManager.child2() = sphere()
    override fun NodeManager.child3() = sphere { }

    override fun Sphere.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(64, divisions)
    }
}
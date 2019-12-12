package ktfx.layouts.scene.shape

import javafx.scene.shape.Sphere
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.sphere
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class SphereTest : BaseLayoutTest<NodeManager, Sphere>() {

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
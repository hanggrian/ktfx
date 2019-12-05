package ktfx.layouts.scene.shape

import javafx.scene.shape.Sphere
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.sphere
import kotlin.test.assertEquals

class SphereTest : LayoutTest<NodeManager, Sphere>() {

    override fun createManager() = KtfxPane()
    override fun create() = sphere { }
    override fun NodeManager.add() = sphere()
    override fun NodeManager.addWithBuilder() = sphere { }

    override fun Sphere.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(64, divisions)
    }
}
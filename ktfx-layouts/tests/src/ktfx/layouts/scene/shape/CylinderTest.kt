package ktfx.layouts.scene.shape

import javafx.scene.shape.Cylinder
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.cylinder
import kotlin.test.assertEquals

class CylinderTest : LayoutTest<NodeManager, Cylinder>() {

    override fun createManager() = KtfxPane()
    override fun create() = cylinder { }
    override fun NodeManager.add() = cylinder()
    override fun NodeManager.addWithBuilder() = cylinder { }

    override fun Cylinder.testDefaultValues() {
        assertEquals(1.0, radius)
        assertEquals(2.0, height)
        assertEquals(64, divisions)
    }
}
package ktfx.layouts

import javafx.scene.shape.VLineTo
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class VLineToTest : LayoutsTest<PathElementManager, VLineTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = vlineTo { }
    override fun PathElementManager.child2() = vlineTo()
    override fun PathElementManager.child3() = vlineTo { }

    override fun VLineTo.testDefaultValues() {
        assertEquals(0.0, y)
    }
}
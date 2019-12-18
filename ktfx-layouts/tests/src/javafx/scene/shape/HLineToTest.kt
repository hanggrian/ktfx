package ktfx.layouts

import javafx.scene.shape.HLineTo
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class HLineToTest : BaseLayoutTest<PathElementManager, HLineTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = hlineTo { }
    override fun PathElementManager.child2() = hlineTo()
    override fun PathElementManager.child3() = hlineTo { }

    override fun HLineTo.testDefaultValues() {
        assertEquals(0.0, x)
    }
}
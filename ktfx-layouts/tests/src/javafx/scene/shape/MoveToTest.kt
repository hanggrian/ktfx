package ktfx.layouts

import javafx.scene.shape.MoveTo
import ktfx.test.BaseLayoutTest
import kotlin.test.assertEquals

class MoveToTest : BaseLayoutTest<PathElementManager, MoveTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = moveTo { }
    override fun PathElementManager.child2() = moveTo()
    override fun PathElementManager.child3() = moveTo { }

    override fun MoveTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
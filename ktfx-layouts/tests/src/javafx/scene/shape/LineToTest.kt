package ktfx.layouts

import javafx.scene.shape.LineTo
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class LineToTest : LayoutsTest<PathElementManager, LineTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = lineTo { }
    override fun PathElementManager.child2() = lineTo()
    override fun PathElementManager.child3() = lineTo { }

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
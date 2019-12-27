package ktfx.layouts

import javafx.scene.shape.QuadCurveTo
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class QuadCurveToTest : LayoutsTest<PathElementManager, QuadCurveTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = quadCurveTo { }
    override fun PathElementManager.child2() = quadCurveTo()
    override fun PathElementManager.child3() = quadCurveTo { }

    override fun QuadCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
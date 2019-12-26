package ktfx.layouts

import javafx.scene.shape.CubicCurveTo
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class CubicCurveToTest : LayoutTest<PathElementManager, CubicCurveTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = cubicCurveTo { }
    override fun PathElementManager.child2() = cubicCurveTo()
    override fun PathElementManager.child3() = cubicCurveTo { }

    override fun CubicCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX1)
        assertEquals(0.0, controlX2)
        assertEquals(0.0, controlY1)
        assertEquals(0.0, controlY2)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
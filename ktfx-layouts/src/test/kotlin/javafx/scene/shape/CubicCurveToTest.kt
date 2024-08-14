package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.CubicCurveTo
import kotlin.test.assertEquals

class CubicCurveToTest : LayoutsTest<KtfxPath, CubicCurveTo>() {
    override fun manager() = KtfxPath()

    override fun KtfxPath.childCount() = elements.size

    override fun child1() = cubicCurveTo {}

    override fun KtfxPath.child2() = cubicCurveTo()

    override fun CubicCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX1)
        assertEquals(0.0, controlX2)
        assertEquals(0.0, controlY1)
        assertEquals(0.0, controlY2)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}

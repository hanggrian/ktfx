package ktfx.layouts.scene.shape

import javafx.scene.shape.CubicCurveTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.cubicCurveTo
import kotlin.test.assertEquals

class CubicCurveToTest : LayoutTest<PathElementManager, CubicCurveTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = cubicCurveTo { }
    override fun PathElementManager.add() = cubicCurveTo()
    override fun PathElementManager.addWithBuilder() = cubicCurveTo { }

    override fun CubicCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX1)
        assertEquals(0.0, controlX2)
        assertEquals(0.0, controlY1)
        assertEquals(0.0, controlY2)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
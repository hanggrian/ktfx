package ktfx.layouts.scene.shape

import javafx.scene.shape.QuadCurveTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.quadCurveTo
import kotlin.test.assertEquals

class QuadCurveToTest : LayoutTest<PathElementManager, QuadCurveTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = quadCurveTo { }
    override fun PathElementManager.add() = quadCurveTo()
    override fun PathElementManager.addWithBuilder() = quadCurveTo { }

    override fun QuadCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
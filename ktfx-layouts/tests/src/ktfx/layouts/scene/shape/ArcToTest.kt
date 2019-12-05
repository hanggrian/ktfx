package ktfx.layouts.scene.shape

import javafx.scene.shape.ArcTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.LayoutTest
import ktfx.layouts.PathElementManager
import ktfx.layouts.arcTo
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ArcToTest : LayoutTest<PathElementManager, ArcTo>() {

    override fun createManager() = KtfxPath()
    override fun create() = arcTo { }
    override fun PathElementManager.add() = arcTo()
    override fun PathElementManager.addWithBuilder() = arcTo { }

    override fun ArcTo.testDefaultValues() {
        assertEquals(0.0, radiusX)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, xAxisRotation)
        assertEquals(0.0, radiusY)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
        assertFalse(isLargeArcFlag)
        assertFalse(isSweepFlag)
    }
}
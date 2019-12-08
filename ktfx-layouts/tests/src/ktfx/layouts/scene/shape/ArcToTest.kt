package ktfx.layouts.scene.shape

import javafx.scene.shape.ArcTo
import ktfx.layouts.KtfxPath
import ktfx.layouts.PathElementManager
import ktfx.layouts.arcTo
import ktfx.test.LayoutTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ArcToTest : LayoutTest<PathElementManager, ArcTo>() {

    override fun manager() = KtfxPath()
    override fun childCount() = manager.childCount
    override fun child1() = arcTo { }
    override fun PathElementManager.child2() = arcTo()
    override fun PathElementManager.child3() = arcTo { }

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
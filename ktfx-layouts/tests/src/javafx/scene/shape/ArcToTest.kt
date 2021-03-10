package ktfx.layouts

import javafx.scene.shape.ArcTo
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class ArcToTest : LayoutsTest<KtfxPath, ArcTo>() {

    override fun manager() = KtfxPath()
    override fun KtfxPath.childCount() = elements.size
    override fun child1() = arcTo { }
    override fun KtfxPath.child2() = arcTo()
    override fun KtfxPath.child3() = arcTo { }

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
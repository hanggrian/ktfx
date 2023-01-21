package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.QuadCurveTo
import kotlin.test.assertEquals

class QuadCurveToTest : LayoutsTest<KtfxPath, QuadCurveTo>() {
    override fun manager(): KtfxPath = KtfxPath()
    override fun KtfxPath.childCount(): Int = elements.size
    override fun child1(): QuadCurveTo = quadCurveTo { }
    override fun KtfxPath.child2(): QuadCurveTo = quadCurveTo()
    override fun KtfxPath.child3(): QuadCurveTo = quadCurveTo { }

    override fun QuadCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}

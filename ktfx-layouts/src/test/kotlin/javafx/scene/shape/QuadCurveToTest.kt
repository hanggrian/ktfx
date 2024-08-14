package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.QuadCurveTo
import kotlin.test.assertEquals

class QuadCurveToTest : LayoutsTest<KtfxPath, QuadCurveTo>() {
    override fun manager() = KtfxPath()

    override fun KtfxPath.childCount() = elements.size

    override fun child1() = quadCurveTo {}

    override fun KtfxPath.child2() = quadCurveTo()

    override fun QuadCurveTo.testDefaultValues() {
        assertEquals(0.0, controlX)
        assertEquals(0.0, controlY)
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}

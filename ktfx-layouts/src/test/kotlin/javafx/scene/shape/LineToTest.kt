package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.LineTo
import kotlin.test.assertEquals

class LineToTest : LayoutsTest<KtfxPath, LineTo>() {
    override fun manager() = KtfxPath()

    override fun KtfxPath.childCount() = elements.size

    override fun child1() = lineTo {}

    override fun KtfxPath.child2() = lineTo()

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}

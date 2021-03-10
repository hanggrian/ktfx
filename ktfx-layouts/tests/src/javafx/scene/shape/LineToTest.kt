package ktfx.layouts

import javafx.scene.shape.LineTo
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class LineToTest : LayoutsTest<KtfxPath, LineTo>() {

    override fun manager() = KtfxPath()
    override fun KtfxPath.childCount() = elements.size
    override fun child1() = lineTo { }
    override fun KtfxPath.child2() = lineTo()
    override fun KtfxPath.child3() = lineTo { }

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}
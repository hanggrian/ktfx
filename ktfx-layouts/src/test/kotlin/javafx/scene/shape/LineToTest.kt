package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.LineTo
import kotlin.test.assertEquals

class LineToTest : LayoutsTest<KtfxPath, LineTo>() {
    override fun manager(): KtfxPath = KtfxPath()
    override fun KtfxPath.childCount(): Int = elements.size
    override fun child1(): LineTo = lineTo { }
    override fun KtfxPath.child2(): LineTo = lineTo()
    override fun KtfxPath.child3(): LineTo = lineTo { }

    override fun LineTo.testDefaultValues() {
        assertEquals(0.0, x)
        assertEquals(0.0, y)
    }
}

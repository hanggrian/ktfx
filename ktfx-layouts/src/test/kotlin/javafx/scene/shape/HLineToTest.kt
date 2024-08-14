package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.HLineTo
import kotlin.test.assertEquals

class HLineToTest : LayoutsTest<KtfxPath, HLineTo>() {
    override fun manager() = KtfxPath()

    override fun KtfxPath.childCount() = elements.size

    override fun child1() = hlineTo {}

    override fun KtfxPath.child2() = hlineTo()

    override fun HLineTo.testDefaultValues() {
        assertEquals(0.0, x)
    }
}

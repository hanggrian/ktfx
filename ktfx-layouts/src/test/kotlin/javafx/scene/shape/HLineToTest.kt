package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.HLineTo
import kotlin.test.assertEquals

class HLineToTest : LayoutsTest<KtfxPath, HLineTo>() {
    override fun manager(): KtfxPath = KtfxPath()

    override fun KtfxPath.childCount(): Int = elements.size

    override fun child1(): HLineTo = hlineTo { }

    override fun KtfxPath.child2(): HLineTo = hlineTo()

    override fun KtfxPath.child3(): HLineTo = hlineTo { }

    override fun HLineTo.testDefaultValues() {
        assertEquals(0.0, x)
    }
}

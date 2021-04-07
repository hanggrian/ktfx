package ktfx.layouts

import javafx.scene.shape.HLineTo
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class HLineToTest : LayoutsTest<KtfxPath, HLineTo>() {

    override fun manager() = KtfxPath()
    override fun KtfxPath.childCount() = elements.size
    override fun child1() = hlineTo { }
    override fun KtfxPath.child2() = hlineTo()
    override fun KtfxPath.child3() = hlineTo { }

    override fun HLineTo.testDefaultValues() {
        assertEquals(0.0, x)
    }
}
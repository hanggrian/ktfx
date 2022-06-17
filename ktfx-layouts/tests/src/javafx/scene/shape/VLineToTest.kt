package ktfx.layouts

import javafx.scene.shape.VLineTo
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class VLineToTest : LayoutsTest<KtfxPath, VLineTo>() {

    override fun manager() = KtfxPath()
    override fun KtfxPath.childCount() = elements.size
    override fun child1() = vlineTo { }
    override fun KtfxPath.child2() = vlineTo()
    override fun KtfxPath.child3() = vlineTo { }

    override fun VLineTo.testDefaultValues() {
        assertEquals(0.0, y)
    }
}

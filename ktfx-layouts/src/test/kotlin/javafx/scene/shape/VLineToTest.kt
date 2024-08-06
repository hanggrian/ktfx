package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.VLineTo
import kotlin.test.assertEquals

class VLineToTest : LayoutsTest<KtfxPath, VLineTo>() {
    override fun manager(): KtfxPath = KtfxPath()

    override fun KtfxPath.childCount(): Int = elements.size

    override fun child1(): VLineTo = vlineTo { }

    override fun KtfxPath.child2(): VLineTo = vlineTo()

    override fun KtfxPath.child3(): VLineTo = vlineTo { }

    override fun VLineTo.testDefaultValues() {
        assertEquals(0.0, y)
    }
}

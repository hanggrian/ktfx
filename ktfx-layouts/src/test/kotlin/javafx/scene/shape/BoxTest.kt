package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.Box
import kotlin.test.assertEquals

class BoxTest : LayoutsStyledTest<KtfxPane, Box>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = box {}

    override fun KtfxPane.child2() = box()

    override fun child3() = styledBox()

    override fun KtfxPane.child4() = styledBox()

    override fun Box.testDefaultValues() {
        assertEquals(Box.DEFAULT_SIZE, width)
        assertEquals(Box.DEFAULT_SIZE, height)
        assertEquals(Box.DEFAULT_SIZE, depth)
    }
}

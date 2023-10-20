package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.Box
import kotlin.test.assertEquals

class BoxTest : LayoutsTest<KtfxPane, Box>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): Box = box { }

    override fun KtfxPane.child2(): Box = box()

    override fun KtfxPane.child3(): Box = box { }

    override fun Box.testDefaultValues() {
        assertEquals(Box.DEFAULT_SIZE, width)
        assertEquals(Box.DEFAULT_SIZE, height)
        assertEquals(Box.DEFAULT_SIZE, depth)
    }
}

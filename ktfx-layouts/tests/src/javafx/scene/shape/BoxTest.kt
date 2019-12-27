package ktfx.layouts

import javafx.scene.shape.Box
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class BoxTest : LayoutsTest<NodeManager, Box>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = box { }
    override fun NodeManager.child2() = box()
    override fun NodeManager.child3() = box { }

    override fun Box.testDefaultValues() {
        assertEquals(Box.DEFAULT_SIZE, width)
        assertEquals(Box.DEFAULT_SIZE, height)
        assertEquals(Box.DEFAULT_SIZE, depth)
    }
}
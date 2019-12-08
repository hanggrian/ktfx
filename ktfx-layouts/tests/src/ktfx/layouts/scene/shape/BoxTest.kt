package ktfx.layouts.scene.shape

import javafx.scene.shape.Box
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.box
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class BoxTest : LayoutTest<NodeManager, Box>() {

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
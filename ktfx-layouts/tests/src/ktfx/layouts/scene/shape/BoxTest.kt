package ktfx.layouts.scene.shape

import javafx.scene.shape.Box
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.box
import kotlin.test.assertEquals

class BoxTest : LayoutTest<NodeManager, Box>() {

    override fun createManager() = KtfxPane()
    override fun create() = box { }
    override fun NodeManager.add() = box()
    override fun NodeManager.addWithBuilder() = box { }

    override fun Box.testDefaultValues() {
        assertEquals(Box.DEFAULT_SIZE, width)
        assertEquals(Box.DEFAULT_SIZE, height)
        assertEquals(Box.DEFAULT_SIZE, depth)
    }
}
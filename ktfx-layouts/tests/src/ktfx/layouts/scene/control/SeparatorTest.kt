package ktfx.layouts.scene.control

import javafx.geometry.Orientation
import javafx.scene.control.Separator
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.separator
import ktfx.layouts.verticalSeparator
import kotlin.test.Test
import kotlin.test.assertEquals

class SeparatorTest : LayoutTest<NodeManager, Separator>() {

    override fun createManager() = KtfxPane()
    override fun create() = separator { }
    override fun NodeManager.add() = separator()
    override fun NodeManager.addWithBuilder() = separator { }

    @Test fun verticalSeparator() {
        verticalSeparator {
            assertEquals(Orientation.VERTICAL, orientation)
        }
    }
}
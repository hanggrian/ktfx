package ktfx.layouts.scene.control

import javafx.geometry.Orientation
import javafx.scene.control.Separator
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.separator
import ktfx.layouts.verticalSeparator
import ktfx.test.BaseLayoutTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SeparatorTest : BaseLayoutTest<NodeManager, Separator>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = separator { }
    override fun NodeManager.child2() = separator()
    override fun NodeManager.child3() = separator { }

    @Test fun verticalSeparator() {
        verticalSeparator {
            assertEquals(Orientation.VERTICAL, orientation)
        }
    }
}
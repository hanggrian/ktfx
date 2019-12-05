package ktfx.layouts.scene.control

import javafx.scene.control.SplitMenuButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.menuItem
import ktfx.layouts.splitMenuButton
import ktfx.test.assertEmpty
import kotlin.test.Test
import kotlin.test.assertEquals

class SplitMenuButtonTest : LayoutTest<NodeManager, SplitMenuButton>() {

    override fun createManager() = KtfxPane()
    override fun create() = splitMenuButton { }
    override fun NodeManager.add() = splitMenuButton()
    override fun NodeManager.addWithBuilder() = splitMenuButton { }

    @Test fun stringInvocation() {
        splitMenuButton {
            assertEmpty(items)
            menuItem("Hello")
            "World" {
            }
            assertEquals(2, items.size)
        }
    }
}
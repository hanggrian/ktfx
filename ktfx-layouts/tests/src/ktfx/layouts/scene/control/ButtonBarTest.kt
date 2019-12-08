package ktfx.layouts.scene.control

import javafx.scene.control.ButtonBar
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.button
import ktfx.layouts.buttonBar
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import org.apache.commons.lang3.SystemUtils
import kotlin.test.Test
import kotlin.test.assertEquals

class ButtonBarTest : LayoutTest<NodeManager, ButtonBar>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = buttonBar { }
    override fun NodeManager.child2() = buttonBar()
    override fun NodeManager.child3() = buttonBar { }

    override fun ButtonBar.testDefaultValues() {
        assertEquals(
            when {
                SystemUtils.IS_OS_WINDOWS -> ButtonBar.BUTTON_ORDER_WINDOWS
                SystemUtils.IS_OS_MAC -> ButtonBar.BUTTON_ORDER_MAC_OS
                SystemUtils.IS_OS_LINUX -> ButtonBar.BUTTON_ORDER_LINUX
                else -> ButtonBar.BUTTON_ORDER_NONE
            }, buttonOrder
        )
    }

    @Test fun stringInvocation() {
        buttonBar {
            assertEmpty(buttons)
            button("Hello")
            "World" {
            }
            assertEquals(2, buttons.size)
        }
    }
}
package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ButtonBar
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.apache.commons.lang3.SystemUtils
import kotlin.test.Test
import kotlin.test.assertEquals

class ButtonBarTest : LayoutsTest<KtfxPane, ButtonBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = buttonBar { }
    override fun KtfxPane.child2() = buttonBar()
    override fun KtfxPane.child3() = buttonBar { }

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

    @Test
    fun stringInvocation() {
        buttonBar {
            assertThat(buttons).isEmpty()
            button("Hello")
            "World" {
            }
            assertEquals(2, buttons.size)
        }
    }
}

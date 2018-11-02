package ktfx.layouts.scene.control

import ktfx.layouts.buttonBar
import ktfx.test.ToolkitLayoutTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class ButtonBarTest : ToolkitLayoutTest() {

    override fun newInstance() {
        buttonBar {
            assertEmpty(buttons)
            "Hello"()
            "World"()
            assertEquals(2, buttons.size)
        }
    }

    override fun withManager() {
    }
}
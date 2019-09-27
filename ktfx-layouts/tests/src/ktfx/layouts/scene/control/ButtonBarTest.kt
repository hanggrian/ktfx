package ktfx.layouts.scene.control

import ktfx.layouts.NodeManager
import ktfx.layouts.KtfxPane
import ktfx.layouts.button
import ktfx.layouts.buttonBar
import ktfx.test.LayoutToolkitTest
import ktfx.test.assertEmpty
import kotlin.test.assertEquals

class ButtonBarTest : LayoutToolkitTest<NodeManager>(KtfxPane()) {

    override fun NodeManager.layout() {
        buttonBar {
            assertEmpty(buttons)
            button("Hello")
            button("World")
            assertEquals(2, buttons.size)
        }
    }
}
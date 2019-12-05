package ktfx.layouts.scene.control

import javafx.scene.control.Button
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.button
import kotlin.test.assertNull

class ButtonTest : LayoutTest<NodeManager, Button>() {

    override fun createManager() = KtfxPane()
    override fun create() = button { }
    override fun NodeManager.add() = button()
    override fun NodeManager.addWithBuilder() = button { }

    override fun Button.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
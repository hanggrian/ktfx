package ktfx.layouts.scene.control

import javafx.scene.control.Button
import javafx.scene.control.ToggleButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.button
import ktfx.layouts.toggleButton
import kotlin.test.assertNull

class ToggleButtonTest : LayoutTest<NodeManager, ToggleButton>() {

    override fun createManager() = KtfxPane()
    override fun create() = toggleButton { }
    override fun NodeManager.add() = toggleButton()
    override fun NodeManager.addWithBuilder() = toggleButton { }

    override fun ToggleButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
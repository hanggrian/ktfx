package ktfx.layouts.scene.control

import javafx.scene.control.ToggleButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.toggleButton
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class ToggleButtonTest : BaseLayoutTest<NodeManager, ToggleButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = toggleButton { }
    override fun NodeManager.child2() = toggleButton()
    override fun NodeManager.child3() = toggleButton { }

    override fun ToggleButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
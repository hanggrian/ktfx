package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import org.controlsfx.control.ToggleSwitch
import kotlin.test.assertNull

class ToggleSwitchTest : BaseLayoutTest<NodeManager, ToggleSwitch>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = toggleSwitch { }
    override fun NodeManager.child2() = toggleSwitch()
    override fun NodeManager.child3() = toggleSwitch { }

    override fun ToggleSwitch.testDefaultValues() {
        assertNull(text)
    }
}
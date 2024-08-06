package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.ToggleSwitch
import kotlin.test.assertNull

class ToggleSwitchTest : LayoutsTest<KtfxPane, ToggleSwitch>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ToggleSwitch = toggleSwitch { }

    override fun KtfxPane.child2(): ToggleSwitch = toggleSwitch()

    override fun KtfxPane.child3(): ToggleSwitch = toggleSwitch { }

    override fun ToggleSwitch.testDefaultValues() {
        assertNull(text)
    }
}

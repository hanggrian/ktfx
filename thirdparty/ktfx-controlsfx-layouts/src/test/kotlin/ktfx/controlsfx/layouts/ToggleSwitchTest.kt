package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.ToggleSwitch
import kotlin.test.assertNull

class ToggleSwitchTest : LayoutsStyledTest<KtfxPane, ToggleSwitch>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = toggleSwitch {}

    override fun KtfxPane.child2() = toggleSwitch()

    override fun child3() = styledToggleSwitch()

    override fun KtfxPane.child4() = styledToggleSwitch()

    override fun ToggleSwitch.testDefaultValues() {
        assertNull(text)
    }
}

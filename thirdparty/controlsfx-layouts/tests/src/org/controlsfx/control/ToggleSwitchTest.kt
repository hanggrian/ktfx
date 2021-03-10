package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.ToggleSwitch
import kotlin.test.assertNull

class ToggleSwitchTest : LayoutsTest<KtfxPane, ToggleSwitch>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = toggleSwitch { }
    override fun KtfxPane.child2() = toggleSwitch()
    override fun KtfxPane.child3() = toggleSwitch { }

    override fun ToggleSwitch.testDefaultValues() {
        assertNull(text)
    }
}
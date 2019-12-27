package ktfx.layouts

import javafx.scene.control.ToggleButton
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ToggleButtonTest : LayoutsTest<NodeManager, ToggleButton>() {

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
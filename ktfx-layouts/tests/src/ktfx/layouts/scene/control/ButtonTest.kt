package ktfx.layouts.scene.control

import javafx.scene.control.Button
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.button
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class ButtonTest : BaseLayoutTest<NodeManager, Button>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = button { }
    override fun NodeManager.child2() = button()
    override fun NodeManager.child3() = button { }

    override fun Button.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class JFXButtonTest : LayoutTest<NodeManager, JFXButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxButton { }
    override fun NodeManager.child2() = jfxButton()
    override fun NodeManager.child3() = jfxButton { }

    override fun JFXButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
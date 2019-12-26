package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class JFXRadioButtonTest : LayoutTest<NodeManager, JFXRadioButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxRadioButton { }
    override fun NodeManager.child2() = jfxRadioButton()
    override fun NodeManager.child3() = jfxRadioButton { }

    override fun JFXRadioButton.testDefaultValues() {
        assertNull(text)
    }
}
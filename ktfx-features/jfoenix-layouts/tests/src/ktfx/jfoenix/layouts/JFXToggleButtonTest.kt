package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXToggleButtonTest : LayoutTest<NodeManager, JFXToggleButton>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxToggleButton { }
    override fun NodeManager.child2() = jfxToggleButton()
    override fun NodeManager.child3() = jfxToggleButton { }
}
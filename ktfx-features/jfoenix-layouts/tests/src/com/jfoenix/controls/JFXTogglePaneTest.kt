package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXTogglePaneTest : BaseLayoutTest<NodeManager, JFXTogglePane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTogglePane { }
    override fun NodeManager.child2() = jfxTogglePane()
    override fun NodeManager.child3() = jfxTogglePane { }
}
package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXClippedPaneTest : BaseLayoutTest<NodeManager, JFXClippedPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxClippedPane { }
    override fun NodeManager.child2() = jfxClippedPane()
    override fun NodeManager.child3() = jfxClippedPane { }
}
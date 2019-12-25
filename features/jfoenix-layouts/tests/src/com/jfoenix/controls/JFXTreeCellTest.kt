package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeCell
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXTreeCellTest : BaseLayoutTest<NodeManager, JFXTreeCell<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTreeCell<String> { }
    override fun NodeManager.child2() = jfxTreeCell<String>()
    override fun NodeManager.child3() = jfxTreeCell<String> { }
}
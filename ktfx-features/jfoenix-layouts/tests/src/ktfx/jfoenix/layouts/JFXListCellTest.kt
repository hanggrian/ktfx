package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXListCellTest : LayoutTest<NodeManager, JFXListCell<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxListCell<String> { }
    override fun NodeManager.child2() = jfxListCell<String>()
    override fun NodeManager.child3() = jfxListCell<String> { }
}
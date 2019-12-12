package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXListViewTest : BaseLayoutTest<NodeManager, JFXListView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxListView<String> { }
    override fun NodeManager.child2() = jfxListView<String>()
    override fun NodeManager.child3() = jfxListView<String> { }
}
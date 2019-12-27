package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest

class JFXNodesListTest : LayoutsTest<NodeManager, JFXNodesList>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxNodesList { }
    override fun NodeManager.child2() = jfxNodesList()
    override fun NodeManager.child3() = jfxNodesList { }
}
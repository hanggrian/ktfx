package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest

class JFXMasonryPaneTest : LayoutsTest<NodeManager, JFXMasonryPane>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxMasonryPane { }
    override fun NodeManager.child2() = jfxMasonryPane()
    override fun NodeManager.child3() = jfxMasonryPane { }
}
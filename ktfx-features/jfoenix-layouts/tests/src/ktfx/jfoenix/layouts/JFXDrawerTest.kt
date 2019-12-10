package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXDrawerTest : LayoutTest<NodeManager, JFXDrawer>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxDrawer { }
    override fun NodeManager.child2() = jfxDrawer()
    override fun NodeManager.child3() = jfxDrawer { }
}
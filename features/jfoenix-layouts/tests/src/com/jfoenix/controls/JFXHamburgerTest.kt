package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXHamburgerTest : LayoutTest<NodeManager, JFXHamburger>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxHamburger { }
    override fun NodeManager.child2() = jfxHamburger()
    override fun NodeManager.child3() = jfxHamburger { }
}
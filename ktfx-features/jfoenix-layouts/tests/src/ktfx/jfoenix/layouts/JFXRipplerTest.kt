package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXRipplerTest : LayoutTest<NodeManager, JFXRippler>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxRippler { }
    override fun NodeManager.child2() = jfxRippler()
    override fun NodeManager.child3() = jfxRippler { }
}
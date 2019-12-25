package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest

class JFXBadgeTest : BaseLayoutTest<NodeManager, JFXBadge>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxBadge { }
    override fun NodeManager.child2() = jfxBadge()
    override fun NodeManager.child3() = jfxBadge { }
}
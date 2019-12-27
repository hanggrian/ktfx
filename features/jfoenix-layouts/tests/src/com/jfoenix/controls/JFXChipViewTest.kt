package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest

class JFXChipViewTest : LayoutsTest<NodeManager, JFXChipView<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxChipView<String> { }
    override fun NodeManager.child2() = jfxChipView<String>()
    override fun NodeManager.child3() = jfxChipView<String> { }
}
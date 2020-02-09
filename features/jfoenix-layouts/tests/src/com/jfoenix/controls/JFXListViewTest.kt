package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest

class JFXListViewTest : LayoutsTest<KtfxPane, JFXListView<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxListView<String> { }
    override fun KtfxPane.child2() = jfxListView<String>()
    override fun KtfxPane.child3() = jfxListView<String> { }
}
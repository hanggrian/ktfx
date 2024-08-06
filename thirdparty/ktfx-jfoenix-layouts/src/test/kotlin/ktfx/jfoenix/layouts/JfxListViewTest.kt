package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXListView
import ktfx.layouts.KtfxPane

class JfxListViewTest : LayoutsTest<KtfxPane, JFXListView<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXListView<String> = jfxListView { }

    override fun KtfxPane.child2(): JFXListView<String> = jfxListView()

    override fun KtfxPane.child3(): JFXListView<String> = jfxListView { }
}

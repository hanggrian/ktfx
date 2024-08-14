package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXListView
import ktfx.layouts.KtfxPane

class JfxListViewTest : LayoutsStyledTest<KtfxPane, JFXListView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxListView<String> {}

    override fun KtfxPane.child2() = jfxListView<String>()

    override fun child3() = styledJfxListView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxListView<String>(styleClass = arrayOf("style"))
}

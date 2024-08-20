package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXTreeView
import com.jfoenix.controls.JFXTreeViewPath
import ktfx.layouts.KtfxPane

class JfxTreeViewPathTest : LayoutsStyledTest<KtfxPane, JFXTreeViewPath>() {
    private lateinit var jfxTreeView: JFXTreeView<String>

    override fun onCreate() {
        super.onCreate()
        jfxTreeView = JFXTreeView()
    }

    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxTreeViewPath(jfxTreeView) {}

    override fun KtfxPane.child2() = jfxTreeViewPath(jfxTreeView)

    override fun child3() = styledJfxTreeViewPath(jfxTreeView)

    override fun KtfxPane.child4() = styledJfxTreeViewPath(jfxTreeView)
}

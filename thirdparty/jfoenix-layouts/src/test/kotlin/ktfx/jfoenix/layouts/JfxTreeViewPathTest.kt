package ktfx.jfoenix.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXTreeView
import com.jfoenix.controls.JFXTreeViewPath
import ktfx.layouts.KtfxPane

class JfxTreeViewPathTest : LayoutsTest<KtfxPane, JFXTreeViewPath>() {
    private lateinit var jfxTreeView: JFXTreeView<String>

    override fun onCreate() {
        super.onCreate()
        jfxTreeView = JFXTreeView()
    }

    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXTreeViewPath = jfxTreeViewPath(jfxTreeView) { }

    override fun KtfxPane.child2(): JFXTreeViewPath = jfxTreeViewPath(jfxTreeView)

    override fun KtfxPane.child3(): JFXTreeViewPath = jfxTreeViewPath(jfxTreeView) { }
}

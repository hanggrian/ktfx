package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTreeView
import com.jfoenix.controls.JFXTreeViewPath
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest

class JFXTreeViewPathTest : LayoutTest<NodeManager, JFXTreeViewPath>() {
    private lateinit var jfxTreeView: JFXTreeView<String>

    override fun onCreate() {
        super.onCreate()
        jfxTreeView = JFXTreeView()
    }

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTreeViewPath(jfxTreeView) { }
    override fun NodeManager.child2() = jfxTreeViewPath(jfxTreeView)
    override fun NodeManager.child3() = jfxTreeViewPath(jfxTreeView) { }
}
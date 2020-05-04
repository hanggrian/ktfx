package ktfx.layouts

import javafx.scene.layout.Pane
import com.hendraanggrian.ktfx.test.LayoutsTest

class PaneTest : LayoutsTest<KtfxPane, Pane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = pane { }
    override fun KtfxPane.child2() = pane()
    override fun KtfxPane.child3() = pane { }
}
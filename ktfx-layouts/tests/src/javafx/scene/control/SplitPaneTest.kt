package ktfx.layouts

import javafx.scene.control.SplitPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class SplitPaneTest : LayoutsTest<KtfxPane, SplitPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = splitPane { }
    override fun KtfxPane.child2() = splitPane()
    override fun KtfxPane.child3() = splitPane { }
}

package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.SplitPane

class SplitPaneTest : LayoutsTest<KtfxPane, SplitPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): SplitPane = splitPane { }
    override fun KtfxPane.child2(): SplitPane = splitPane()
    override fun KtfxPane.child3(): SplitPane = splitPane { }
}

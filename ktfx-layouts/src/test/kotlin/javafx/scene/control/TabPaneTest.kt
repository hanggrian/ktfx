package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.TabPane

class TabPaneTest : LayoutsTest<KtfxPane, TabPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): TabPane = tabPane { }
    override fun KtfxPane.child2(): TabPane = tabPane()
    override fun KtfxPane.child3(): TabPane = tabPane { }
}

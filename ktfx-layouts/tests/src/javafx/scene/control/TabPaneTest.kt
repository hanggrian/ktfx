package ktfx.layouts

import javafx.scene.control.TabPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class TabPaneTest : LayoutsTest<KtfxPane, TabPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = tabPane { }
    override fun KtfxPane.child2() = tabPane()
    override fun KtfxPane.child3() = tabPane { }
}
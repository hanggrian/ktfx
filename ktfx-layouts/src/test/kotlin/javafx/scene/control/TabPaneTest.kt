package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.TabPane

class TabPaneTest : LayoutsStyledTest<KtfxPane, TabPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = tabPane {}

    override fun KtfxPane.child2() = tabPane()

    override fun child3() = styledTabPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledTabPane(styleClass = arrayOf("style"))
}

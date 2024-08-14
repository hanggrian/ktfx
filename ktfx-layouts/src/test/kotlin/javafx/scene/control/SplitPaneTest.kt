package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.SplitPane

class SplitPaneTest : LayoutsStyledTest<KtfxPane, SplitPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = splitPane {}

    override fun KtfxPane.child2() = splitPane()

    override fun child3() = styledSplitPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledSplitPane(styleClass = arrayOf("style"))
}

package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.StackPane

class StackPaneTest : LayoutsStyledTest<KtfxPane, StackPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = stackPane {}

    override fun KtfxPane.child2() = stackPane()

    override fun child3() = styledStackPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledStackPane(styleClass = arrayOf("style"))
}

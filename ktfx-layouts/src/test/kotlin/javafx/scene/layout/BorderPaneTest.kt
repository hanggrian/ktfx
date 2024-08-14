package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.BorderPane

class BorderPaneTest : LayoutsStyledTest<KtfxPane, BorderPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = borderPane {}

    override fun KtfxPane.child2() = borderPane()

    override fun child3() = styledBorderPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledBorderPane(styleClass = arrayOf("style"))
}

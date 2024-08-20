package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Pane

class PaneTest : LayoutsStyledTest<KtfxPane, Pane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = pane {}

    override fun KtfxPane.child2() = pane()

    override fun child3() = styledPane()

    override fun KtfxPane.child4() = styledPane()
}

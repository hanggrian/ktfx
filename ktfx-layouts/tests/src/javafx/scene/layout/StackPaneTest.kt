package ktfx.layouts

import javafx.scene.layout.StackPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class StackPaneTest : LayoutsTest<KtfxPane, StackPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = stackPane { }
    override fun KtfxPane.child2() = stackPane()
    override fun KtfxPane.child3() = stackPane { }
}

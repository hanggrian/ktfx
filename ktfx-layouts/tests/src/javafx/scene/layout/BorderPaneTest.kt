package ktfx.layouts

import javafx.scene.layout.BorderPane
import com.hendraanggrian.ktfx.test.LayoutsTest

class BorderPaneTest : LayoutsTest<KtfxPane, BorderPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = borderPane { }
    override fun KtfxPane.child2() = borderPane()
    override fun KtfxPane.child3() = borderPane { }
}

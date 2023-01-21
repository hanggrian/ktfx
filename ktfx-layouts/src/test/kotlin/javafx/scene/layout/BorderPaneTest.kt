package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.BorderPane

class BorderPaneTest : LayoutsTest<KtfxPane, BorderPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): BorderPane = borderPane { }
    override fun KtfxPane.child2(): BorderPane = borderPane()
    override fun KtfxPane.child3(): BorderPane = borderPane { }
}

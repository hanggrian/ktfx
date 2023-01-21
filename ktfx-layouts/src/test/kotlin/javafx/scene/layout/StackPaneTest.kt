package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.layout.StackPane

class StackPaneTest : LayoutsTest<KtfxPane, StackPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): StackPane = stackPane { }
    override fun KtfxPane.child2(): StackPane = stackPane()
    override fun KtfxPane.child3(): StackPane = stackPane { }
}

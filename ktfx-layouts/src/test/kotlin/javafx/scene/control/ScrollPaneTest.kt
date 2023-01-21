package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ScrollPane
import kotlin.test.assertNull

class ScrollPaneTest : LayoutsTest<KtfxPane, ScrollPane>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): ScrollPane = scrollPane { }
    override fun KtfxPane.child2(): ScrollPane = scrollPane()
    override fun KtfxPane.child3(): ScrollPane = scrollPane { }

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}

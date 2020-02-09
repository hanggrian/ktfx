package ktfx.layouts

import javafx.scene.control.ScrollPane
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ScrollPaneTest : LayoutsTest<KtfxPane, ScrollPane>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = scrollPane { }
    override fun KtfxPane.child2() = scrollPane()
    override fun KtfxPane.child3() = scrollPane { }

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}
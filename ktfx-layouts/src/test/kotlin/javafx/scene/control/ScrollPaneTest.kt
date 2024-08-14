package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ScrollPane
import kotlin.test.assertNull

class ScrollPaneTest : LayoutsStyledTest<KtfxPane, ScrollPane>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = scrollPane {}

    override fun KtfxPane.child2() = scrollPane()

    override fun child3() = styledScrollPane(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledScrollPane(styleClass = arrayOf("style"))

    override fun ScrollPane.testDefaultValues() {
        assertNull(content)
    }
}

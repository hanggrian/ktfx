package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.CheckTreeView
import kotlin.test.assertNull

class CheckTreeViewTest : LayoutsStyledTest<KtfxPane, CheckTreeView<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = checkTreeView<String> {}

    override fun KtfxPane.child2() = checkTreeView<String>()

    override fun child3() = styledCheckTreeView<String>(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCheckTreeView<String>(styleClass = arrayOf("style"))

    override fun CheckTreeView<String>.testDefaultValues() {
        assertNull(root)
    }
}

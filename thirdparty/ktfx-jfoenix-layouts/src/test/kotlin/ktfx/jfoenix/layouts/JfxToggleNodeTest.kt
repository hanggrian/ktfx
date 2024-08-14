package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXToggleNode
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxToggleNodeTest : LayoutsStyledTest<KtfxPane, JFXToggleNode>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxToggleNode {}

    override fun KtfxPane.child2() = jfxToggleNode()

    override fun child3() = styledJfxToggleNode(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxToggleNode(styleClass = arrayOf("style"))

    override fun JFXToggleNode.testDefaultValues() {
        assertNull(graphic)
    }
}

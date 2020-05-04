package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleNode
import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXToggleNodeTest : LayoutsTest<KtfxPane, JFXToggleNode>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = jfxToggleNode { }
    override fun KtfxPane.child2() = jfxToggleNode()
    override fun KtfxPane.child3() = jfxToggleNode { }

    override fun JFXToggleNode.testDefaultValues() {
        assertNull(graphic)
    }
}
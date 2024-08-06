package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXToggleNode
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxToggleNodeTest : LayoutsTest<KtfxPane, JFXToggleNode>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXToggleNode = jfxToggleNode { }

    override fun KtfxPane.child2(): JFXToggleNode = jfxToggleNode()

    override fun KtfxPane.child3(): JFXToggleNode = jfxToggleNode { }

    override fun JFXToggleNode.testDefaultValues() {
        assertNull(graphic)
    }
}

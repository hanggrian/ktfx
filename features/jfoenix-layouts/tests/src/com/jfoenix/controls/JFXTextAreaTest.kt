package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextArea
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class JFXTextAreaTest : LayoutTest<NodeManager, JFXTextArea>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTextArea { }
    override fun NodeManager.child2() = jfxTextArea()
    override fun NodeManager.child3() = jfxTextArea { }

    override fun JFXTextArea.testDefaultValues() {
        assertNull(text)
    }
}
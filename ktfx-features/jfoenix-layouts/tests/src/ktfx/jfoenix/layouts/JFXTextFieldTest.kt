package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class JFXTextFieldTest : BaseLayoutTest<NodeManager, JFXTextField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxTextField { }
    override fun NodeManager.child2() = jfxTextField()
    override fun NodeManager.child3() = jfxTextField { }

    override fun JFXTextField.testDefaultValues() {
        assertNull(text)
    }
}
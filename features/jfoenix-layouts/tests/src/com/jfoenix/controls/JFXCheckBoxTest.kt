package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXCheckBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class JFXCheckBoxTest : LayoutsTest<NodeManager, JFXCheckBox>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = jfxCheckBox { }
    override fun NodeManager.child2() = jfxCheckBox()
    override fun NodeManager.child3() = jfxCheckBox { }

    override fun JFXCheckBox.testDefaultValues() {
        assertNull(text)
    }
}
package ktfx.layouts

import javafx.scene.control.CheckBox
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class CheckBoxTest : LayoutsTest<NodeManager, CheckBox>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = checkBox { }
    override fun NodeManager.child2() = checkBox()
    override fun NodeManager.child3() = checkBox { }

    override fun CheckBox.testDefaultValues() {
        assertNull(text)
    }
}
package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutsTest
import org.controlsfx.control.textfield.CustomTextField

class CustomTextFieldTest : LayoutsTest<NodeManager, CustomTextField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = customTextField { }
    override fun NodeManager.child2() = customTextField()
    override fun NodeManager.child3() = customTextField { }
}
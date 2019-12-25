package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import org.controlsfx.control.textfield.CustomPasswordField

class CustomPasswordFieldTest : BaseLayoutTest<NodeManager, CustomPasswordField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = customPasswordField { }
    override fun NodeManager.child2() = customPasswordField()
    override fun NodeManager.child3() = customPasswordField { }
}
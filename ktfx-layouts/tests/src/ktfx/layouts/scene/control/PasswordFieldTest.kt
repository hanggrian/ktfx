package ktfx.layouts.scene.control

import javafx.scene.control.PasswordField
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.passwordField
import ktfx.test.BaseLayoutTest

class PasswordFieldTest : BaseLayoutTest<NodeManager, PasswordField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = passwordField { }
    override fun NodeManager.child2() = passwordField()
    override fun NodeManager.child3() = passwordField { }
}
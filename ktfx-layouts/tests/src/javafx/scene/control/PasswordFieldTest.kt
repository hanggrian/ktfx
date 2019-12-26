package ktfx.layouts

import javafx.scene.control.PasswordField
import ktfx.test.LayoutTest

class PasswordFieldTest : LayoutTest<NodeManager, PasswordField>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = passwordField { }
    override fun NodeManager.child2() = passwordField()
    override fun NodeManager.child3() = passwordField { }
}
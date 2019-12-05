package ktfx.layouts.scene.control

import javafx.scene.control.PasswordField
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.passwordField

class PasswordFieldTest : LayoutTest<NodeManager, PasswordField>() {

    override fun createManager() = KtfxPane()
    override fun create() = passwordField { }
    override fun NodeManager.add() = passwordField()
    override fun NodeManager.addWithBuilder() = passwordField { }
}
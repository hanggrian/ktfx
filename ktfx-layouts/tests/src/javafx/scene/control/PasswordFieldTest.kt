package ktfx.layouts

import javafx.scene.control.PasswordField
import com.hendraanggrian.ktfx.test.LayoutsTest

class PasswordFieldTest : LayoutsTest<KtfxPane, PasswordField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = passwordField { }
    override fun KtfxPane.child2() = passwordField()
    override fun KtfxPane.child3() = passwordField { }
}

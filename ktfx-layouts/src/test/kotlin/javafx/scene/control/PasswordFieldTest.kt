package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.PasswordField

class PasswordFieldTest : LayoutsTest<KtfxPane, PasswordField>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): PasswordField = passwordField { }

    override fun KtfxPane.child2(): PasswordField = passwordField()

    override fun KtfxPane.child3(): PasswordField = passwordField { }
}

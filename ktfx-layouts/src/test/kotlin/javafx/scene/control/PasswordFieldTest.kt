package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.PasswordField

class PasswordFieldTest : LayoutsStyledTest<KtfxPane, PasswordField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = passwordField {}

    override fun KtfxPane.child2() = passwordField()

    override fun child3() = styledPasswordField(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledPasswordField(styleClass = arrayOf("style"))
}

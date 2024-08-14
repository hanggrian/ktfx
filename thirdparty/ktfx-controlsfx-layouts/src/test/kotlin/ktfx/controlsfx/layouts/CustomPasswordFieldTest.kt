package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.textfield.CustomPasswordField

class CustomPasswordFieldTest : LayoutsStyledTest<KtfxPane, CustomPasswordField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = customPasswordField {}

    override fun KtfxPane.child2() = customPasswordField()

    override fun child3() = styledCustomPasswordField(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCustomPasswordField(styleClass = arrayOf("style"))
}

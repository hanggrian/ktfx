package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.textfield.CustomPasswordField

class CustomPasswordFieldTest : LayoutsTest<KtfxPane, CustomPasswordField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = customPasswordField { }
    override fun KtfxPane.child2() = customPasswordField()
    override fun KtfxPane.child3() = customPasswordField { }
}
package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.textfield.CustomPasswordField

class CustomPasswordFieldTest : LayoutsTest<KtfxPane, CustomPasswordField>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CustomPasswordField = customPasswordField { }

    override fun KtfxPane.child2(): CustomPasswordField = customPasswordField()

    override fun KtfxPane.child3(): CustomPasswordField = customPasswordField { }
}

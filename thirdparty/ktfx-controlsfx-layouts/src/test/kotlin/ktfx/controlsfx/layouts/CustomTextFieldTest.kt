package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.textfield.CustomTextField

class CustomTextFieldTest : LayoutsStyledTest<KtfxPane, CustomTextField>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = customTextField {}

    override fun KtfxPane.child2() = customTextField()

    override fun child3() = styledCustomTextField(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledCustomTextField(styleClass = arrayOf("style"))
}

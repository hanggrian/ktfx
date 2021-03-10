package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.textfield.CustomTextField

class CustomTextFieldTest : LayoutsTest<KtfxPane, CustomTextField>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = customTextField { }
    override fun KtfxPane.child2() = customTextField()
    override fun KtfxPane.child3() = customTextField { }
}
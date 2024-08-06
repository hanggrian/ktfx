package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.textfield.CustomTextField

class CustomTextFieldTest : LayoutsTest<KtfxPane, CustomTextField>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): CustomTextField = customTextField { }

    override fun KtfxPane.child2(): CustomTextField = customTextField()

    override fun KtfxPane.child3(): CustomTextField = customTextField { }
}

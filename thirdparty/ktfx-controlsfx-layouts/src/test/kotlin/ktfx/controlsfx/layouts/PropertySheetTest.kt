package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PropertySheet

class PropertySheetTest : LayoutsStyledTest<KtfxPane, PropertySheet>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = propertySheet {}

    override fun KtfxPane.child2() = propertySheet()

    override fun child3() = styledPropertySheet()

    override fun KtfxPane.child4() = styledPropertySheet()

    override fun PropertySheet.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}

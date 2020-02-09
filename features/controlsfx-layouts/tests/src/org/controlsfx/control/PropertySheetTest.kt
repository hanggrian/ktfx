package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.test.LayoutsTest
import org.controlsfx.control.PropertySheet

class PropertySheetTest : LayoutsTest<KtfxPane, PropertySheet>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = propertySheet { }
    override fun KtfxPane.child2() = propertySheet()
    override fun KtfxPane.child3() = propertySheet { }

    override fun PropertySheet.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
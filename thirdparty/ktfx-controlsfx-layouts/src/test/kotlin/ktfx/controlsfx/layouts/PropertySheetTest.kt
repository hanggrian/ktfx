package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.PropertySheet

class PropertySheetTest : LayoutsTest<KtfxPane, PropertySheet>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): PropertySheet = propertySheet { }

    override fun KtfxPane.child2(): PropertySheet = propertySheet()

    override fun KtfxPane.child3(): PropertySheet = propertySheet { }

    override fun PropertySheet.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}

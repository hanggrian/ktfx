package ktfx.controlsfx.layouts

import com.google.common.truth.Truth.assertThat
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import org.controlsfx.control.PropertySheet

class PropertySheetTest : LayoutTest<NodeManager, PropertySheet>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = propertySheet { }
    override fun NodeManager.child2() = propertySheet()
    override fun NodeManager.child3() = propertySheet { }

    override fun PropertySheet.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
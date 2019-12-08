package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.LayoutTest
import ktfx.test.assertEmpty
import org.controlsfx.control.PropertySheet
import kotlin.test.assertNull

class PropertySheetTest : LayoutTest<NodeManager, PropertySheet>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = propertySheet { }
    override fun NodeManager.child2() = propertySheet()
    override fun NodeManager.child3() = propertySheet { }

    override fun PropertySheet.testDefaultValues() {
        assertEmpty(items)
    }
}
package ktfx.layouts

import javafx.scene.control.TitledPane
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class TitledPaneTest : LayoutTest<TitledPaneManager, TitledPane>() {

    override fun manager() = KtfxAccordion()
    override fun childCount() = manager.childCount
    override fun child1() = titledPane { }
    override fun TitledPaneManager.child2() = titledPane()
    override fun TitledPaneManager.child3() = titledPane { }

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
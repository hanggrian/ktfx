package ktfx.layouts

import javafx.scene.control.TitledPane
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class TitledPaneTest : BaseLayoutTest<TitledPaneManager, TitledPane>() {

    override fun manager() = KtfxAccordion()
    override fun childCount() = manager.childCount
    override fun child1() = titledPane { }
    override fun TitledPaneManager.child2() = titledPane()
    override fun TitledPaneManager.child3() = titledPane { }

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
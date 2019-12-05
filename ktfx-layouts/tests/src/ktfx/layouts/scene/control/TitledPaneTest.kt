package ktfx.layouts.scene.control

import javafx.scene.control.TitledPane
import ktfx.layouts.KtfxAccordion
import ktfx.layouts.LayoutTest
import ktfx.layouts.TitledPaneManager
import ktfx.layouts.titledPane
import kotlin.test.assertNull

class TitledPaneTest : LayoutTest<TitledPaneManager, TitledPane>() {

    override fun createManager() = KtfxAccordion()
    override fun create() = titledPane { }
    override fun TitledPaneManager.add() = titledPane()
    override fun TitledPaneManager.addWithBuilder() = titledPane { }

    override fun TitledPane.testDefaultValues() {
        assertNull(text)
    }
}
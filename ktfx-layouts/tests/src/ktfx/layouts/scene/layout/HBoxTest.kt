package ktfx.layouts.scene.layout

import javafx.scene.layout.HBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.hbox
import kotlin.test.assertEquals

class HBoxTest : LayoutTest<NodeManager, HBox>() {

    override fun createManager() = KtfxPane()
    override fun create() = hbox { }
    override fun NodeManager.add() = hbox()
    override fun NodeManager.addWithBuilder() = hbox { }

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
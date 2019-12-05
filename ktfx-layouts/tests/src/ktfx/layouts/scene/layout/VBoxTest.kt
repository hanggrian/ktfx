package ktfx.layouts.scene.layout

import javafx.scene.layout.VBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.vbox
import kotlin.test.assertEquals

class VBoxTest : LayoutTest<NodeManager, VBox>() {

    override fun createManager() = KtfxPane()
    override fun create() = vbox { }
    override fun NodeManager.add() = vbox()
    override fun NodeManager.addWithBuilder() = vbox { }

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
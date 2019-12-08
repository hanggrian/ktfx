package ktfx.layouts.scene.layout

import javafx.scene.layout.VBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.vbox
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class VBoxTest : LayoutTest<NodeManager, VBox>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = vbox { }
    override fun NodeManager.child2() = vbox()
    override fun NodeManager.child3() = vbox { }

    override fun VBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
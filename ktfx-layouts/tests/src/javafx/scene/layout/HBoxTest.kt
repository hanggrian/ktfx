package ktfx.layouts

import javafx.scene.layout.HBox
import ktfx.test.LayoutTest
import kotlin.test.assertEquals

class HBoxTest : LayoutTest<NodeManager, HBox>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = hbox { }
    override fun NodeManager.child2() = hbox()
    override fun NodeManager.child3() = hbox { }

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
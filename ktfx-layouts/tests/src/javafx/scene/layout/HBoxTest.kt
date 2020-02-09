package ktfx.layouts

import javafx.scene.layout.HBox
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals

class HBoxTest : LayoutsTest<KtfxPane, HBox>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = hbox { }
    override fun KtfxPane.child2() = hbox()
    override fun KtfxPane.child3() = hbox { }

    override fun HBox.testDefaultValues() {
        assertEquals(0.0, spacing)
    }
}
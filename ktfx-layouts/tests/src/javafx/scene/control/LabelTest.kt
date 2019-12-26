package ktfx.layouts

import javafx.scene.control.Label
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class LabelTest : LayoutTest<NodeManager, Label>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = label { }
    override fun NodeManager.child2() = label()
    override fun NodeManager.child3() = label { }

    override fun Label.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
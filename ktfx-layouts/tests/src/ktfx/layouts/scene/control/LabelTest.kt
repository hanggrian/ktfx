package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.label
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class LabelTest : BaseLayoutTest<NodeManager, Label>() {

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
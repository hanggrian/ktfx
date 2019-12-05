package ktfx.layouts.scene.control

import javafx.scene.control.Label
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.label
import kotlin.test.assertNull

class LabelTest : LayoutTest<NodeManager, Label>() {

    override fun createManager() = KtfxPane()
    override fun create() = label { }
    override fun NodeManager.add() = label()
    override fun NodeManager.addWithBuilder() = label { }

    override fun Label.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
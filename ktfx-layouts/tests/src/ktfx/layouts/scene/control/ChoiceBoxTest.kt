package ktfx.layouts.scene.control

import javafx.scene.control.ChoiceBox
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.choiceBox
import ktfx.test.assertEmpty

class ChoiceBoxTest : LayoutTest<NodeManager, ChoiceBox<String>>() {

    override fun createManager() = KtfxPane()
    override fun create() = choiceBox<String> { }
    override fun NodeManager.add() = choiceBox<String>()
    override fun NodeManager.addWithBuilder() = choiceBox<String> { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}
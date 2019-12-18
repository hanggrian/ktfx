package ktfx.layouts

import javafx.scene.control.ChoiceBox
import ktfx.test.BaseLayoutTest
import ktfx.test.assertEmpty

class ChoiceBoxTest : BaseLayoutTest<NodeManager, ChoiceBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = choiceBox<String> { }
    override fun NodeManager.child2() = choiceBox<String>()
    override fun NodeManager.child3() = choiceBox<String> { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertEmpty(items)
    }
}
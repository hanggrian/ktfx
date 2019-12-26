package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ChoiceBox
import ktfx.test.LayoutTest

class ChoiceBoxTest : LayoutTest<NodeManager, ChoiceBox<String>>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = choiceBox<String> { }
    override fun NodeManager.child2() = choiceBox<String>()
    override fun NodeManager.child3() = choiceBox<String> { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
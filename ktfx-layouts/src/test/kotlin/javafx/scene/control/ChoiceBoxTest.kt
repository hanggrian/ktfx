package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ChoiceBox

class ChoiceBoxTest : LayoutsTest<KtfxPane, ChoiceBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ChoiceBox<String> = choiceBox { }

    override fun KtfxPane.child2(): ChoiceBox<String> = choiceBox()

    override fun KtfxPane.child3(): ChoiceBox<String> = choiceBox { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}

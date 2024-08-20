package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ChoiceBox

class ChoiceBoxTest : LayoutsStyledTest<KtfxPane, ChoiceBox<String>>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = choiceBox<String> {}

    override fun KtfxPane.child2() = choiceBox<String>()

    override fun child3() = styledChoiceBox<String>()

    override fun KtfxPane.child4() = styledChoiceBox<String>()

    override fun ChoiceBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}

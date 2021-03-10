package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import javafx.scene.control.ChoiceBox
import io.github.hendraanggrian.ktfx.test.LayoutsTest

class ChoiceBoxTest : LayoutsTest<KtfxPane, ChoiceBox<String>>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = choiceBox<String> { }
    override fun KtfxPane.child2() = choiceBox<String>()
    override fun KtfxPane.child3() = choiceBox<String> { }

    override fun ChoiceBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}
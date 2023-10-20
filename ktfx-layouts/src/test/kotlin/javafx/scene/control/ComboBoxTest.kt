package ktfx.layouts

import com.google.common.truth.Truth.assertThat
import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ComboBox

class ComboBoxTest : LayoutsTest<KtfxPane, ComboBox<String>>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ComboBox<String> = comboBox { }

    override fun KtfxPane.child2(): ComboBox<String> = comboBox()

    override fun KtfxPane.child3(): ComboBox<String> = comboBox { }

    override fun ComboBox<String>.testDefaultValues() {
        assertThat(items).isEmpty()
    }
}

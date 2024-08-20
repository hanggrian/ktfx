package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.RadioButton
import kotlin.test.assertNull

class RadioButtonTest : LayoutsStyledTest<KtfxPane, RadioButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = radioButton {}

    override fun KtfxPane.child2() = radioButton()

    override fun child3() = styledRadioButton()

    override fun KtfxPane.child4() = styledRadioButton()

    override fun RadioButton.testDefaultValues() {
        assertNull(text)
    }
}

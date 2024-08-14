package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxRadioButtonTest : LayoutsStyledTest<KtfxPane, JFXRadioButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = jfxRadioButton {}

    override fun KtfxPane.child2() = jfxRadioButton()

    override fun child3() = styledJfxRadioButton(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledJfxRadioButton(styleClass = arrayOf("style"))

    override fun JFXRadioButton.testDefaultValues() {
        assertNull(text)
    }
}

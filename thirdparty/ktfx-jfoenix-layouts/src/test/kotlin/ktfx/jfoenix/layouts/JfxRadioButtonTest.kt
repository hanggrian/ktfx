package ktfx.jfoenix.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import com.jfoenix.controls.JFXRadioButton
import ktfx.layouts.KtfxPane
import kotlin.test.assertNull

class JfxRadioButtonTest : LayoutsTest<KtfxPane, JFXRadioButton>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): JFXRadioButton = jfxRadioButton { }

    override fun KtfxPane.child2(): JFXRadioButton = jfxRadioButton()

    override fun KtfxPane.child3(): JFXRadioButton = jfxRadioButton { }

    override fun JFXRadioButton.testDefaultValues() {
        assertNull(text)
    }
}

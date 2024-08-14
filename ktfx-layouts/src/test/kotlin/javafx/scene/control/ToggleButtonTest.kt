package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.ToggleButton
import kotlin.test.assertNull

class ToggleButtonTest : LayoutsStyledTest<KtfxPane, ToggleButton>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = toggleButton {}

    override fun KtfxPane.child2() = toggleButton()

    override fun child3() = styledToggleButton(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledToggleButton(styleClass = arrayOf("style"))

    override fun ToggleButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Button
import kotlin.test.assertNull

class ButtonTest : LayoutsStyledTest<KtfxButtonBar, Button>() {
    override fun manager() = KtfxButtonBar(null)

    override fun KtfxButtonBar.childCount() = buttons.size

    override fun child1() = button {}

    override fun KtfxButtonBar.child2() = button()

    override fun child3() = styledButton()

    override fun KtfxButtonBar.child4() = styledButton()

    override fun Button.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

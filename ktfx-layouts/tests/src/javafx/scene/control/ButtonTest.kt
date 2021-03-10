package ktfx.layouts

import javafx.scene.control.Button
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ButtonTest : LayoutsTest<KtfxButtonBar, Button>() {

    override fun manager() = KtfxButtonBar(null)
    override fun KtfxButtonBar.childCount() = buttons.size
    override fun child1() = button { }
    override fun KtfxButtonBar.child2() = button()
    override fun KtfxButtonBar.child3() = button { }

    override fun Button.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
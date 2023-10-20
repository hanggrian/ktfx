package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Button
import kotlin.test.assertNull

class ButtonTest : LayoutsTest<KtfxButtonBar, Button>() {
    override fun manager(): KtfxButtonBar = KtfxButtonBar(null)

    override fun KtfxButtonBar.childCount(): Int = buttons.size

    override fun child1(): Button = button { }

    override fun KtfxButtonBar.child2(): Button = button()

    override fun KtfxButtonBar.child3(): Button = button { }

    override fun Button.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

package ktfx.layouts

import javafx.scene.control.ToggleButton
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ToggleButtonTest : LayoutsTest<KtfxPane, ToggleButton>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = toggleButton { }
    override fun KtfxPane.child2() = toggleButton()
    override fun KtfxPane.child3() = toggleButton { }

    override fun ToggleButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

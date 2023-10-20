package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ToggleButton
import kotlin.test.assertNull

class ToggleButtonTest : LayoutsTest<KtfxPane, ToggleButton>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ToggleButton = toggleButton { }

    override fun KtfxPane.child2(): ToggleButton = toggleButton()

    override fun KtfxPane.child3(): ToggleButton = toggleButton { }

    override fun ToggleButton.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

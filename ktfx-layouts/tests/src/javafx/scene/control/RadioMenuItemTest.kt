package ktfx.layouts

import javafx.scene.control.RadioMenuItem
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class RadioMenuItemTest : LayoutsTest<KtfxMenu, RadioMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = radioMenuItem { }
    override fun KtfxMenu.child2() = radioMenuItem()
    override fun KtfxMenu.child3() = radioMenuItem { }

    override fun RadioMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
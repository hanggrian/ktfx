package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.RadioMenuItem
import kotlin.test.assertNull

class RadioMenuItemTest : LayoutsTest<KtfxMenu, RadioMenuItem>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)
    override fun KtfxMenu.childCount(): Int = items.size
    override fun child1(): RadioMenuItem = radioMenuItem { }
    override fun KtfxMenu.child2(): RadioMenuItem = radioMenuItem()
    override fun KtfxMenu.child3(): RadioMenuItem = radioMenuItem { }

    override fun RadioMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

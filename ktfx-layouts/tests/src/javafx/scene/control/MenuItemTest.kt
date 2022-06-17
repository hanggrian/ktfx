package ktfx.layouts

import javafx.scene.control.MenuItem
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class MenuItemTest : LayoutsTest<KtfxMenu, MenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = menuItem { }
    override fun KtfxMenu.child2() = menuItem()
    override fun KtfxMenu.child3() = menuItem { }

    override fun MenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

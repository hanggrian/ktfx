package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.MenuItem
import kotlin.test.assertNull

class MenuItemTest : LayoutsTest<KtfxMenu, MenuItem>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)

    override fun KtfxMenu.childCount(): Int = items.size

    override fun child1(): MenuItem = menuItem { }

    override fun KtfxMenu.child2(): MenuItem = menuItem()

    override fun KtfxMenu.child3(): MenuItem = menuItem { }

    override fun MenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

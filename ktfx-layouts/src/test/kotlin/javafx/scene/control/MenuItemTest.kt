package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.MenuItem
import kotlin.test.assertNull

class MenuItemTest : LayoutsStyledTest<KtfxMenu, MenuItem>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = menuItem {}

    override fun KtfxMenu.child2() = menuItem()

    override fun child3() = styledMenuItem(styleClass = arrayOf("style"))

    override fun KtfxMenu.child4() = styledMenuItem(styleClass = arrayOf("style"))

    override fun MenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

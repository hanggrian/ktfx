package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.CustomMenuItem
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : LayoutsTest<KtfxMenu, CustomMenuItem>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)

    override fun KtfxMenu.childCount(): Int = items.size

    override fun child1(): CustomMenuItem = customMenuItem { }

    override fun KtfxMenu.child2(): CustomMenuItem = customMenuItem()

    override fun KtfxMenu.child3(): CustomMenuItem = customMenuItem { }

    override fun CustomMenuItem.testDefaultValues() {
        assertNull(content)
        assertTrue(isHideOnClick)
    }
}

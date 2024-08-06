package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.CheckMenuItem
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutsTest<KtfxMenu, CheckMenuItem>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)

    override fun KtfxMenu.childCount(): Int = items.size

    override fun child1(): CheckMenuItem = checkMenuItem { }

    override fun KtfxMenu.child2(): CheckMenuItem = checkMenuItem()

    override fun KtfxMenu.child3(): CheckMenuItem = checkMenuItem { }

    override fun CheckMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

package ktfx.layouts

import javafx.scene.control.CustomMenuItem
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : LayoutsTest<KtfxMenu, CustomMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = customMenuItem { }
    override fun KtfxMenu.child2() = customMenuItem()
    override fun KtfxMenu.child3() = customMenuItem { }

    override fun CustomMenuItem.testDefaultValues() {
        assertNull(content)
        assertTrue(isHideOnClick)
    }
}

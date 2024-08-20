package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.CustomMenuItem
import kotlin.test.assertNull
import kotlin.test.assertTrue

class CustomMenuItemTest : LayoutsStyledTest<KtfxMenu, CustomMenuItem>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = customMenuItem {}

    override fun KtfxMenu.child2() = customMenuItem()

    override fun child3() = styledCustomMenuItem()

    override fun KtfxMenu.child4() = styledCustomMenuItem()

    override fun CustomMenuItem.testDefaultValues() {
        assertNull(content)
        assertTrue(isHideOnClick)
    }
}

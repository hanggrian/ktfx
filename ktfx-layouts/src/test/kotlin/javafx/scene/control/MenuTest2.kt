package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Menu
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest2 : LayoutsStyledTest<KtfxMenuBar, Menu>() {
    override fun manager() = KtfxMenuBar()

    override fun KtfxMenuBar.childCount() = menus.size

    override fun child1() = menu {}

    override fun KtfxMenuBar.child2() = menu()

    override fun child3() = styledMenu()

    override fun KtfxMenuBar.child4() = styledMenu()

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}

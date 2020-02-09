package ktfx.layouts

import javafx.scene.control.Menu
import ktfx.test.LayoutsTest
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest : LayoutsTest<KtfxMenu, Menu>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = menu { }
    override fun KtfxMenu.child2() = menu()
    override fun KtfxMenu.child3() = menu { }

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}
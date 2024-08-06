package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.Menu
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest : LayoutsTest<KtfxMenu, Menu>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)

    override fun KtfxMenu.childCount(): Int = items.size

    override fun child1(): Menu = menu { }

    override fun KtfxMenu.child2(): Menu = menu()

    override fun KtfxMenu.child3(): Menu = menu { }

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}

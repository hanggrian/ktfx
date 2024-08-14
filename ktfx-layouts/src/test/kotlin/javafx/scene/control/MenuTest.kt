package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.Menu
import kotlin.test.assertEquals
import kotlin.test.assertNull

class MenuTest : LayoutsStyledTest<KtfxMenu, Menu>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = menu {}

    override fun KtfxMenu.child2() = menu()

    override fun child3() = styledMenu(styleClass = arrayOf("style"))

    override fun KtfxMenu.child4() = styledMenu(styleClass = arrayOf("style"))

    override fun Menu.testDefaultValues() {
        assertEquals("", text)
        assertNull(graphic)
    }
}

package ktfx.layouts

import javafx.scene.control.CheckMenuItem
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutsTest<KtfxMenu, CheckMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = checkMenuItem { }
    override fun KtfxMenu.child2() = checkMenuItem()
    override fun KtfxMenu.child3() = checkMenuItem { }

    override fun CheckMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}
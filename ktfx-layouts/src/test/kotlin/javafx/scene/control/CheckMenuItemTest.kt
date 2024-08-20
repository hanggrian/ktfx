package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.CheckMenuItem
import kotlin.test.assertNull

class CheckMenuItemTest : LayoutsStyledTest<KtfxMenu, CheckMenuItem>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = checkMenuItem {}

    override fun KtfxMenu.child2() = checkMenuItem()

    override fun child3() = styledCheckMenuItem()

    override fun KtfxMenu.child4() = styledCheckMenuItem()

    override fun CheckMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

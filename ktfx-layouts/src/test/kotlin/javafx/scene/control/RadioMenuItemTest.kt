package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.RadioMenuItem
import kotlin.test.assertNull

class RadioMenuItemTest : LayoutsStyledTest<KtfxMenu, RadioMenuItem>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = radioMenuItem {}

    override fun KtfxMenu.child2() = radioMenuItem()

    override fun child3() = styledRadioMenuItem()

    override fun KtfxMenu.child4() = styledRadioMenuItem()

    override fun RadioMenuItem.testDefaultValues() {
        assertNull(text)
        assertNull(graphic)
    }
}

package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.control.SeparatorMenuItem

class SeparatorMenuItemTest : LayoutsStyledTest<KtfxMenu, SeparatorMenuItem>() {
    override fun manager() = KtfxMenu("", null)

    override fun KtfxMenu.childCount() = items.size

    override fun child1() = separatorMenuItem {}

    override fun KtfxMenu.child2() = separatorMenuItem()

    override fun child3() = styledSeparatorMenuItem(styleClass = arrayOf("style"))

    override fun KtfxMenu.child4() = styledSeparatorMenuItem(styleClass = arrayOf("style"))
}

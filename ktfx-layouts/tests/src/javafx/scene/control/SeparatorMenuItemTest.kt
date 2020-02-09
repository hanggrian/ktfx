package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import ktfx.test.LayoutsTest

class SeparatorMenuItemTest : LayoutsTest<KtfxMenu, SeparatorMenuItem>() {

    override fun manager() = KtfxMenu("", null)
    override fun KtfxMenu.childCount() = items.size
    override fun child1() = separatorMenuItem { }
    override fun KtfxMenu.child2() = separatorMenuItem()
    override fun KtfxMenu.child3() = separatorMenuItem { }
}
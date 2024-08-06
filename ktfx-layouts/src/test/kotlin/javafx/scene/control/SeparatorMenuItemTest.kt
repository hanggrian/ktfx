package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.SeparatorMenuItem

class SeparatorMenuItemTest : LayoutsTest<KtfxMenu, SeparatorMenuItem>() {
    override fun manager(): KtfxMenu = KtfxMenu("", null)

    override fun KtfxMenu.childCount(): Int = items.size

    override fun child1(): SeparatorMenuItem = separatorMenuItem { }

    override fun KtfxMenu.child2(): SeparatorMenuItem = separatorMenuItem()

    override fun KtfxMenu.child3(): SeparatorMenuItem = separatorMenuItem { }
}

package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.control.ScrollBar

class ScrollBarTest : LayoutsTest<KtfxPane, ScrollBar>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ScrollBar = scrollBar { }

    override fun KtfxPane.child2(): ScrollBar = scrollBar()

    override fun KtfxPane.child3(): ScrollBar = scrollBar { }
}

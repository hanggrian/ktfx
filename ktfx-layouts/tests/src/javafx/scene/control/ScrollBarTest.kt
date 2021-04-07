package ktfx.layouts

import javafx.scene.control.ScrollBar
import com.hendraanggrian.ktfx.test.LayoutsTest

class ScrollBarTest : LayoutsTest<KtfxPane, ScrollBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = scrollBar { }
    override fun KtfxPane.child2() = scrollBar()
    override fun KtfxPane.child3() = scrollBar { }
}
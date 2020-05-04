package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import com.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.StatusBar

class StatusBarTest : LayoutsTest<KtfxPane, StatusBar>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = statusBar { }
    override fun KtfxPane.child2() = statusBar()
    override fun KtfxPane.child3() = statusBar { }
}
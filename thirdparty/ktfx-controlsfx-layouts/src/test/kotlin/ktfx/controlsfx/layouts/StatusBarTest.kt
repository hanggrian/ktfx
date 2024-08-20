package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.StatusBar

class StatusBarTest : LayoutsStyledTest<KtfxPane, StatusBar>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = statusBar {}

    override fun KtfxPane.child2() = statusBar()

    override fun child3() = styledStatusBar()

    override fun KtfxPane.child4() = styledStatusBar()
}

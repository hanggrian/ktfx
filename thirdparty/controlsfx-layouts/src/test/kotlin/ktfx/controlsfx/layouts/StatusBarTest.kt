package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.StatusBar

class StatusBarTest : LayoutsTest<KtfxPane, StatusBar>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): StatusBar = statusBar { }

    override fun KtfxPane.child2(): StatusBar = statusBar()

    override fun KtfxPane.child3(): StatusBar = statusBar { }
}

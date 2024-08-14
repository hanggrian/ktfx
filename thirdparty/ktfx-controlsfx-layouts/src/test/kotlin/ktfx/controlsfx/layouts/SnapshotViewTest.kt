package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.SnapshotView

class SnapshotViewTest : LayoutsStyledTest<KtfxPane, SnapshotView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = snapshotView {}

    override fun KtfxPane.child2() = snapshotView()

    override fun child3() = styledSnapshotView(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledSnapshotView(styleClass = arrayOf("style"))
}

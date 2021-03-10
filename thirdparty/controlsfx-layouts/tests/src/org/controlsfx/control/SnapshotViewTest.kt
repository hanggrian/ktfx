package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import org.controlsfx.control.SnapshotView

class SnapshotViewTest : LayoutsTest<KtfxPane, SnapshotView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = snapshotView { }
    override fun KtfxPane.child2() = snapshotView()
    override fun KtfxPane.child3() = snapshotView { }
}
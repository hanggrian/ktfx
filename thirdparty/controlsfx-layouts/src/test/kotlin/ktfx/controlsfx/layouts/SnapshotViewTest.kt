package ktfx.controlsfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import ktfx.layouts.KtfxPane
import org.controlsfx.control.SnapshotView

class SnapshotViewTest : LayoutsTest<KtfxPane, SnapshotView>() {
    override fun manager(): KtfxPane = KtfxPane()
    override fun KtfxPane.childCount(): Int = children.size
    override fun child1(): SnapshotView = snapshotView { }
    override fun KtfxPane.child2(): SnapshotView = snapshotView()
    override fun KtfxPane.child3(): SnapshotView = snapshotView { }
}

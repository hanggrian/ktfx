package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.test.BaseLayoutTest
import org.controlsfx.control.SnapshotView

class SnapshotViewTest : BaseLayoutTest<NodeManager, SnapshotView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = snapshotView { }
    override fun NodeManager.child2() = snapshotView()
    override fun NodeManager.child3() = snapshotView { }
}
package ktfx.controlsfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.layout.Region
import ktfx.layouts.KtfxPane
import ktfx.layouts.region
import org.controlsfx.control.SnapshotView
import kotlin.test.Test
import kotlin.test.assertIs

class SnapshotViewTest : LayoutsStyledTest<KtfxPane, SnapshotView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = snapshotView {}

    override fun KtfxPane.child2() = snapshotView()

    override fun child3() = styledSnapshotView()

    override fun KtfxPane.child4() = styledSnapshotView()

    @Test
    fun add() {
        snapshotView {
            region()
            assertIs<Region>(node)
        }
    }
}

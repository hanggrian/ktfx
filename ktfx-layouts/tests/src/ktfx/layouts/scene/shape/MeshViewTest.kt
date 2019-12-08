package ktfx.layouts.scene.shape

import javafx.scene.shape.MeshView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.meshView
import ktfx.test.LayoutTest
import kotlin.test.assertNull

class MeshViewTest : LayoutTest<NodeManager, MeshView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = meshView { }
    override fun NodeManager.child2() = meshView()
    override fun NodeManager.child3() = meshView { }

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}
package ktfx.layouts

import javafx.scene.shape.MeshView
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class MeshViewTest : LayoutsTest<NodeManager, MeshView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = meshView { }
    override fun NodeManager.child2() = meshView()
    override fun NodeManager.child3() = meshView { }

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}
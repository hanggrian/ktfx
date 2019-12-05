package ktfx.layouts.scene.shape

import javafx.scene.shape.MeshView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.meshView
import kotlin.test.assertNull

class MeshViewTest : LayoutTest<NodeManager, MeshView>() {

    override fun createManager() = KtfxPane()
    override fun create() = meshView { }
    override fun NodeManager.add() = meshView()
    override fun NodeManager.addWithBuilder() = meshView { }

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}
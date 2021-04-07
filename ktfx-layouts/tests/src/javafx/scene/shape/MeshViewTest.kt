package ktfx.layouts

import javafx.scene.shape.MeshView
import com.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class MeshViewTest : LayoutsTest<KtfxPane, MeshView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = meshView { }
    override fun KtfxPane.child2() = meshView()
    override fun KtfxPane.child3() = meshView { }

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}
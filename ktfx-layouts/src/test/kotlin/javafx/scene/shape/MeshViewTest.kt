package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.shape.MeshView
import kotlin.test.assertNull

class MeshViewTest : LayoutsTest<KtfxPane, MeshView>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): MeshView = meshView { }

    override fun KtfxPane.child2(): MeshView = meshView()

    override fun KtfxPane.child3(): MeshView = meshView { }

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}

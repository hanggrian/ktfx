package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.shape.MeshView
import kotlin.test.assertNull

class MeshViewTest : LayoutsStyledTest<KtfxPane, MeshView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = meshView {}

    override fun KtfxPane.child2() = meshView()

    override fun child3() = styledMeshView(styleClass = arrayOf("style"))

    override fun KtfxPane.child4() = styledMeshView(styleClass = arrayOf("style"))

    override fun MeshView.testDefaultValues() {
        assertNull(mesh)
    }
}

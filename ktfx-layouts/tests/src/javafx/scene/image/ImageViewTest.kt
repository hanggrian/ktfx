package ktfx.layouts

import javafx.scene.image.ImageView
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ImageViewTest : LayoutsTest<NodeManager, ImageView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = imageView { }
    override fun NodeManager.child2() = imageView()
    override fun NodeManager.child3() = imageView { }

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}
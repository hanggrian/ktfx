package ktfx.layouts.scene.image

import javafx.scene.image.ImageView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.imageView
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class ImageViewTest : BaseLayoutTest<NodeManager, ImageView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = imageView { }
    override fun NodeManager.child2() = imageView()
    override fun NodeManager.child3() = imageView { }

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}
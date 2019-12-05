package ktfx.layouts.scene.image

import javafx.scene.image.ImageView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.imageView
import kotlin.test.assertNull

class ImageViewTest : LayoutTest<NodeManager, ImageView>() {

    override fun createManager() = KtfxPane()
    override fun create() = imageView { }
    override fun NodeManager.add() = imageView()
    override fun NodeManager.addWithBuilder() = imageView { }

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}
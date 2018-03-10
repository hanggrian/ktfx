package kfx.styles

import javafx.scene.image.ImageView
import kotlin.test.assertNotNull

class ImageViewStyleTest : AppTest<ImageView>() {

    override fun newInstance() = ImageView()

    override val style: String
        get() = imageViewStyle {
            image = Urls("test.png")
        }

    override fun assertion() {
        assertNotNull(node.image)
    }
}
package ktfx.styles.scene.image

import javafx.scene.image.ImageView
import ktfx.styles.NodeTest
import ktfx.styles.Urls
import ktfx.styles.imageViewStyle
import kotlin.test.assertNotNull

class ImageViewStyleTest : NodeTest<ImageView>() {

    override fun newInstance() = ImageView()

    override val style: String
        get() = imageViewStyle(true) {
            image = Urls("test.png")
        }

    override fun ImageView.assertion() {
        assertNotNull(image)
    }
}
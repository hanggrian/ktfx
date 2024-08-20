package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.image.ImageView
import kotlin.test.assertNull

class ImageViewTest : LayoutsStyledTest<KtfxPane, ImageView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = imageView {}

    override fun KtfxPane.child2() = imageView()

    override fun child3() = styledImageView()

    override fun KtfxPane.child4() = styledImageView()

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}

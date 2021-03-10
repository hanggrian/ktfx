package ktfx.layouts

import javafx.scene.image.ImageView
import io.github.hendraanggrian.ktfx.test.LayoutsTest
import kotlin.test.assertNull

class ImageViewTest : LayoutsTest<KtfxPane, ImageView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = imageView { }
    override fun KtfxPane.child2() = imageView()
    override fun KtfxPane.child3() = imageView { }

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}
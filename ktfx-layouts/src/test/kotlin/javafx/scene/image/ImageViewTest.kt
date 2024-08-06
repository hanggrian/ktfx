package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsTest
import javafx.scene.image.ImageView
import kotlin.test.assertNull

class ImageViewTest : LayoutsTest<KtfxPane, ImageView>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): ImageView = imageView { }

    override fun KtfxPane.child2(): ImageView = imageView()

    override fun KtfxPane.child3(): ImageView = imageView { }

    override fun ImageView.testDefaultValues() {
        assertNull(image)
    }
}

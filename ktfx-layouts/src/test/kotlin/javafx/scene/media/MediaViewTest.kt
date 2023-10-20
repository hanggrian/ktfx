package ktfx.layouts

import com.hendraanggrian.ktfx.test.LayoutsTest
import javafx.scene.media.MediaView
import kotlin.test.assertNull

class MediaViewTest : LayoutsTest<KtfxPane, MediaView>() {
    override fun manager(): KtfxPane = KtfxPane()

    override fun KtfxPane.childCount(): Int = children.size

    override fun child1(): MediaView = mediaView { }

    override fun KtfxPane.child2(): MediaView = mediaView()

    override fun KtfxPane.child3(): MediaView = mediaView { }

    override fun MediaView.testDefaultValues() {
        assertNull(mediaPlayer)
    }
}

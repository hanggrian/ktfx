package ktfx.layouts

import javafx.scene.media.MediaView
import ktfx.test.LayoutsTest
import kotlin.test.assertNull

class MediaViewTest : LayoutsTest<KtfxPane, MediaView>() {

    override fun manager() = KtfxPane()
    override fun KtfxPane.childCount() = children.size
    override fun child1() = mediaView { }
    override fun KtfxPane.child2() = mediaView()
    override fun KtfxPane.child3() = mediaView { }

    override fun MediaView.testDefaultValues() {
        assertNull(mediaPlayer)
    }
}
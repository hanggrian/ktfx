package ktfx.layouts

import com.hanggrian.ktfx.test.LayoutsStyledTest
import javafx.scene.media.MediaView
import kotlin.test.assertNull

class MediaViewTest : LayoutsStyledTest<KtfxPane, MediaView>() {
    override fun manager() = KtfxPane()

    override fun KtfxPane.childCount() = children.size

    override fun child1() = mediaView {}

    override fun KtfxPane.child2() = mediaView()

    override fun child3() = styledMediaView()

    override fun KtfxPane.child4() = styledMediaView()

    override fun MediaView.testDefaultValues() {
        assertNull(mediaPlayer)
    }
}

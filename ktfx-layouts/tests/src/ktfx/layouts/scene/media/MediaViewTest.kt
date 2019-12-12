package ktfx.layouts.scene.media

import javafx.scene.media.MediaView
import ktfx.layouts.KtfxPane
import ktfx.layouts.NodeManager
import ktfx.layouts.mediaView
import ktfx.test.BaseLayoutTest
import kotlin.test.assertNull

class MediaViewTest : BaseLayoutTest<NodeManager, MediaView>() {

    override fun manager() = KtfxPane()
    override fun childCount() = manager.childCount
    override fun child1() = mediaView { }
    override fun NodeManager.child2() = mediaView()
    override fun NodeManager.child3() = mediaView { }

    override fun MediaView.testDefaultValues() {
        assertNull(mediaPlayer)
    }
}
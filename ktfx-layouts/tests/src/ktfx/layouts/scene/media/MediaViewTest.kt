package ktfx.layouts.scene.media

import javafx.scene.media.MediaView
import ktfx.layouts.KtfxPane
import ktfx.layouts.LayoutTest
import ktfx.layouts.NodeManager
import ktfx.layouts.mediaView
import kotlin.test.assertNull

class MediaViewTest : LayoutTest<NodeManager, MediaView>() {

    override fun createManager() = KtfxPane()
    override fun create() = mediaView { }
    override fun NodeManager.add() = mediaView()
    override fun NodeManager.addWithBuilder() = mediaView { }

    override fun MediaView.testDefaultValues() {
        assertNull(mediaPlayer)
    }
}
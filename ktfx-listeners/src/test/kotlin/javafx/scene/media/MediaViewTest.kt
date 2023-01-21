package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseMediaViewTest
import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView

class MediaViewTest : BaseMediaViewTest() {
    override fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit) = onError(action)
}

package ktfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseMediaViewTest

class MediaViewTest : BaseMediaViewTest() {

    override fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit) =
        onError(Dispatchers.Unconfined) { action(it) }
}
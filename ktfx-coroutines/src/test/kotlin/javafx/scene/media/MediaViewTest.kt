package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseMediaViewTest
import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.Dispatchers

class MediaViewTest : BaseMediaViewTest() {
    override fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit) =
        onError(Dispatchers.Unconfined) { action(it) }
}

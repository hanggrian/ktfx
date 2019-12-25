package ktfx.coroutines

import javafx.scene.media.Media
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseMediaTest

class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) =
        onError(Dispatchers.Unconfined) { action() }
}
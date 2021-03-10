package ktfx.coroutines

import javafx.scene.media.Media
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseMediaTest

class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) =
        onError(Dispatchers.Unconfined) { action() }
}
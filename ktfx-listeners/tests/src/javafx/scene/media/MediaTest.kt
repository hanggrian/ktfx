package ktfx.listeners

import javafx.scene.media.Media
import io.github.hendraanggrian.ktfx.test.BaseMediaTest

class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) = onError(action)
}
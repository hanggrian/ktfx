package ktfx.listeners

import javafx.scene.media.Media
import com.hendraanggrian.ktfx.test.BaseMediaTest

class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) = onError(action)
}
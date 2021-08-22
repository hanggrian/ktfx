package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseMediaTest
import javafx.scene.media.Media
import kotlin.test.Ignore

@Ignore
class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) = onError(action)
}
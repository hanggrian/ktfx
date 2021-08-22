package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseMediaTest
import javafx.scene.media.Media
import kotlinx.coroutines.Dispatchers
import kotlin.test.Ignore

@Ignore
class MediaTest : BaseMediaTest() {

    override fun Media.callOnError(action: () -> Unit) =
        onError(Dispatchers.Unconfined) { action() }
}
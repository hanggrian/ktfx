package ktfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.BaseWebEngineTest
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlinx.coroutines.Dispatchers

class WebEngineTest : BaseWebEngineTest() {

    override fun WebEngine.callOnAlert(action: (WebEvent<String>) -> Unit) =
        onAlert(Dispatchers.Unconfined) { action(it) }

    override fun WebEngine.callOnStatusChanged(action: (WebEvent<String>) -> Unit) =
        onStatusChanged(Dispatchers.Unconfined) { action(it) }

    override fun WebEngine.callOnResized(action: (WebEvent<Rectangle2D>) -> Unit) =
        onResized(Dispatchers.Unconfined) { action(it) }

    override fun WebEngine.callOnVisibilityChanged(action: (WebEvent<Boolean>) -> Unit) =
        onVisibilityChanged(Dispatchers.Unconfined) { action(it) }

    override fun WebEngine.callOnError(action: (WebErrorEvent) -> Unit) =
        onError(Dispatchers.Unconfined) { action(it) }
}
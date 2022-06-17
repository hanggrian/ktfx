package ktfx.listeners

import javafx.geometry.Rectangle2D
import javafx.scene.web.BaseWebEngineTest
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlin.test.Ignore

@Ignore
class WebEngineTest : BaseWebEngineTest() {

    override fun WebEngine.callOnAlert(action: (WebEvent<String>) -> Unit) = onAlert(action)
    override fun WebEngine.callOnStatusChanged(action: (WebEvent<String>) -> Unit) = onStatusChanged(action)
    override fun WebEngine.callOnResized(action: (WebEvent<Rectangle2D>) -> Unit) = onResized(action)
    override fun WebEngine.callOnVisibilityChanged(action: (WebEvent<Boolean>) -> Unit) = onVisibilityChanged(action)
    override fun WebEngine.callOnError(action: (WebErrorEvent) -> Unit) = onError(action)
}

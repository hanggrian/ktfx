@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.event.EventHandler
import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent

inline fun WebEngine.onAlert(
    noinline action: (WebEvent<String>) -> Unit
) = setOnAlert(EventHandler(action))

inline fun WebEngine.onError(
    noinline action: (WebErrorEvent) -> Unit
) = setOnError(EventHandler(action))

inline fun WebEngine.onResized(
    noinline action: (WebEvent<Rectangle2D>) -> Unit
) = setOnResized(EventHandler(action))

inline fun WebEngine.onStatusChanged(
    noinline action: (WebEvent<String>) -> Unit
) = setOnStatusChanged(EventHandler(action))

inline fun WebEngine.onVisibilityChanged(
    noinline action: (WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged(EventHandler(action))
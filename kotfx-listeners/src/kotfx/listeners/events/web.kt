@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent

inline fun WebEngine.onAlert(
    noinline action: (WebEvent<String>) -> Unit
) = setOnAlert { event -> action(event) }

inline fun WebEngine.onError(
    noinline action: (WebErrorEvent) -> Unit
) = setOnError { event -> action(event) }

inline fun WebEngine.onResized(
    noinline action: (WebEvent<Rectangle2D>) -> Unit
) = setOnResized { event -> action(event) }

inline fun WebEngine.onStatusChanged(
    noinline action: (WebEvent<String>) -> Unit
) = setOnStatusChanged { event -> action(event) }

inline fun WebEngine.onVisibilityChanged(
    noinline action: (WebEvent<Boolean>) -> Unit
) = setOnVisibilityChanged { event -> action(event) }
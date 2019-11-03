@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent

/** Sets the JavaScript {@code alert} handler. */
inline fun WebEngine.onAlert(
    noinline action: (WebEvent<String>) -> Unit
): Unit = setOnAlert { event -> action(event) }

/** The event handler called when an error occurs. */
inline fun WebEngine.onError(
    noinline action: (WebErrorEvent) -> Unit
): Unit = setOnError { event -> action(event) }

/** Sets the JavaScript window resize handler. */
inline fun WebEngine.onResized(
    noinline action: (WebEvent<Rectangle2D>) -> Unit
): Unit = setOnResized { event -> action(event) }

/** Sets the JavaScript status handler. */
inline fun WebEngine.onStatusChanged(
    noinline action: (WebEvent<String>) -> Unit
): Unit = setOnStatusChanged { event -> action(event) }

/** Sets the JavaScript window visibility handler. */
inline fun WebEngine.onVisibilityChanged(
    noinline action: (WebEvent<Boolean>) -> Unit
): Unit = setOnVisibilityChanged { event -> action(event) }

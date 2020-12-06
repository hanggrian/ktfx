@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see WebEngine.setOnAlert
 */
public inline fun WebEngine.onAlert(noinline action: (WebEvent<String>) -> Unit) {
    return setOnAlert(action)
}

/**
 * @see WebEngine.setOnStatusChanged
 */
public inline fun WebEngine.onStatusChanged(noinline action: (WebEvent<String>) -> Unit) {
    return setOnStatusChanged(action)
}

/**
 * @see WebEngine.setOnResized
 */
public inline fun WebEngine.onResized(noinline action: (WebEvent<Rectangle2D>) -> Unit) {
    return setOnResized(action)
}

/**
 * @see WebEngine.setOnVisibilityChanged
 */
public inline fun WebEngine.onVisibilityChanged(noinline action: (WebEvent<Boolean>) -> Unit) {
    return setOnVisibilityChanged(action)
}

/**
 * @see WebEngine.setOnError
 */
public inline fun WebEngine.onError(noinline action: (WebErrorEvent) -> Unit) {
    return setOnError(action)
}

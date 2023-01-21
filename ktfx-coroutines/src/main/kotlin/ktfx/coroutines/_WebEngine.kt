@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.geometry.Rectangle2D
import javafx.scene.web.WebEngine
import javafx.scene.web.WebErrorEvent
import javafx.scene.web.WebEvent
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/**
 * @see WebEngine.setOnAlert
 */
public fun WebEngine.onAlert(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WebEvent<String>) -> Unit): Unit = setOnAlert { event ->
        GlobalScope.launch(context) { action(event) } }

/**
 * @see WebEngine.setOnStatusChanged
 */
public fun WebEngine.onStatusChanged(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WebEvent<String>) -> Unit): Unit = setOnStatusChanged {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see WebEngine.setOnResized
 */
public fun WebEngine.onResized(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WebEvent<Rectangle2D>) -> Unit): Unit = setOnResized {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see WebEngine.setOnVisibilityChanged
 */
public fun WebEngine.onVisibilityChanged(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WebEvent<Boolean>) -> Unit): Unit = setOnVisibilityChanged {
        event -> GlobalScope.launch(context) { action(event) } }

/**
 * @see WebEngine.setOnError
 */
public fun WebEngine.onError(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(WebErrorEvent) -> Unit): Unit = setOnError { event ->
        GlobalScope.launch(context) { action(event) } }

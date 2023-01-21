@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
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
 * @see MediaView.setOnError
 */
public fun MediaView.onError(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(MediaErrorEvent) -> Unit): Unit = setOnError { event ->
        GlobalScope.launch(context) { action(event) } }

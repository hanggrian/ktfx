@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.coroutines

import javafx.animation.Animation
import javafx.event.ActionEvent
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
 * @see Animation.setOnFinished
 */
public fun Animation.onFinished(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.(ActionEvent) -> Unit): Unit = setOnFinished { event ->
        GlobalScope.launch(context) { action(event) } }

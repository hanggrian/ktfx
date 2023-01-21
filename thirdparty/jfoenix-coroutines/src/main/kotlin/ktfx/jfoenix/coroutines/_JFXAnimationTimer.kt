@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.transitions.JFXAnimationTimer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * @see JFXAnimationTimer.setOnFinished
 */
public fun JFXAnimationTimer.onFinished(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.() -> Unit): Unit = setOnFinished {
        GlobalScope.launch(context) { action() } }

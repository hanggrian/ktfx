@file:JvmMultifileClass
@file:JvmName("JfoenixCoroutinesKt")
@file:Suppress("ktlint")

package ktfx.jfoenix.coroutines

import com.jfoenix.transitions.JFXAnimationTimer
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
 * @see JFXAnimationTimer.setOnFinished
 */
public fun JFXAnimationTimer.onFinished(context: CoroutineContext = Dispatchers.JavaFx,
        action: suspend CoroutineScope.() -> Unit): Unit = setOnFinished {
        GlobalScope.launch(context) { action() } }

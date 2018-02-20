@file:JvmMultifileClass
@file:JvmName("CallbacksKt")

package kotfx.coroutines

import javafx.concurrent.ScheduledService
import javafx.util.Duration
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

fun <V> ScheduledService<V>.backoffStrategy(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(ScheduledService<*>) -> Duration
) = setBackoffStrategy { param -> runBlocking(context) { action(param) } }
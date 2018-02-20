@file:Suppress("NOTHING_TO_INLINE")

package kotfx.coroutines

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.CoroutineStart.DEFAULT
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withContext

inline fun launchFX(
    start: CoroutineStart = DEFAULT,
    parent: Job? = null,
    noinline block: suspend CoroutineScope.() -> Unit
): Job = launch(JavaFx, start, parent, block)

suspend inline fun <T> withContextFX(
    start: CoroutineStart = DEFAULT,
    noinline block: suspend () -> T
): T = withContext(JavaFx, start, block)

inline fun <T> runBlockingFX(
    noinline block: suspend CoroutineScope.() -> T
): T = runBlocking(JavaFx, block)
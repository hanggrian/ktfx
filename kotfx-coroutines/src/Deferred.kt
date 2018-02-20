@file:Suppress("NOTHING_TO_INLINE")

package kotfx.coroutines

import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.CoroutineStart.DEFAULT
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.javafx.JavaFx

inline fun <T> asyncFX(
    start: CoroutineStart = DEFAULT,
    parent: Job? = null,
    noinline block: suspend CoroutineScope.() -> T
): Deferred<T> = async(JavaFx, start, parent, block)
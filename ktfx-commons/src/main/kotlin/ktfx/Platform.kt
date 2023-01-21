@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.application.ConditionalFeature
import javafx.application.Platform
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Returns true if the calling thread is the JavaFX thread. */
inline fun isFxThread(): Boolean = Platform.isFxApplicationThread()

/** Queries whether a specific conditional feature is supported by the platform. */
inline fun ConditionalFeature.isSupported(): Boolean = Platform.isSupported(this)

/**
 * Calls the specified function [block] in JavaFX thread.
 *
 * @see kotlin.run
 */
inline fun runLater(crossinline block: () -> Unit) {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { block() }
}

/**
 * Calls the specified function [block] with `this` value as its receiver in JavaFX thread.
 *
 * @see kotlin.run
 */
inline fun <T> T.runLater(crossinline block: T.() -> Unit) {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { block() }
}

/**
 * Calls the specified function [block] with the given [receiver] as its receiver in JavaFX thread.
 *
 * @see kotlin.with
 */
inline fun <T> withLater(receiver: T, crossinline block: T.() -> Unit) {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { receiver.block() }
}

/**
 * Calls the specified function [block] with `this` value as its receiver and returns `this` value
 * in JavaFX thread.
 *
 * @see kotlin.apply
 */
inline fun <T> T.applyLater(crossinline block: T.() -> Unit): T {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { block() }
    return this
}

/**
 * Calls the specified function [block] with `this` value as its argument and returns `this` value
 * in JavaFX thread.
 *
 * @see kotlin.also
 */
inline fun <T> T.alsoLater(crossinline block: (T) -> Unit): T {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { block(this) }
    return this
}

/**
 * Calls the specified function [block] with `this` value as its argument in JavaFX thread.
 *
 * @see kotlin.let
 */
inline fun <T> T.letLater(crossinline block: (T) -> Unit) {
    contract { callsInPlace(block, InvocationKind.EXACTLY_ONCE) }
    Platform.runLater { block(this) }
}

/**
 * Executes the given function [action] specified number of [times] in JavaFX thread.
 *
 * @see kotlin.repeat
 */
inline fun repeatLater(times: Int, crossinline action: (Int) -> Unit) {
    contract { callsInPlace(action) }
    Platform.runLater { for (index in 0 until times) action(index) }
}

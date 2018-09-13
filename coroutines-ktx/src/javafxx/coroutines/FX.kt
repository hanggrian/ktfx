package javafxx.coroutines

import kotlin.coroutines.experimental.CoroutineContext

/** Typealias for JavaFX coroutine context. */
inline val FX: CoroutineContext get() = kotlinx.coroutines.experimental.javafx.JavaFx
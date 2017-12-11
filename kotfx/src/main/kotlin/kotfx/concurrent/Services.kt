@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.concurrent

import javafx.concurrent.Service

inline fun <V> service(init: ServiceBuilder<V>.() -> Unit): Service<V> = FXServiceBuilder<V>().apply { init() }.build()
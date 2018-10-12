package ktfx.internal

import javafx.concurrent.Task

/** Receiver in `ktfx.concurrent.buildService`, invoke [call] to customize what this Task do in the background. */
@Suppress("ClassName")
class InternalTask<V> : Task<V>() {
    private var _call: () -> V? = { null }

    fun call(onCall: () -> V?) {
        _call = onCall
    }

    override fun call(): V? = _call()
}
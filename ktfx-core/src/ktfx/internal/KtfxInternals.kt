package ktfx.internal

import javafx.util.Callback

/** Ktfx internal class, ignore it. */
object KtfxInternals {

    const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

    /**
     * Kotlin can't have return type of [Void] when used as generics.
     *
     * @param callback that should be invoked as function type.
     * @param P param that is brought by callback.
     * @return callback with no return value.
     */
    fun <P> noReturn(callback: (P) -> Unit): Callback<P, Void> =
        CallbackUtils.noReturn(callback)
}

package ktfx.internal

import javafx.util.Callback

/** Ktfx internal class, ignore it. */
object KtfxInternals {

    const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)

    /** Returns a [Callback] with no return type. */
    inline fun <P> noReturn(crossinline callback: (P) -> Unit): Callback<P, Void> = Callback {
        callback(it)
        null
    }
}

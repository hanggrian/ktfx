package javafxx.internal

object Internals {

    const val NO_GETTER: String = "Property does not have a getter"

    /** Some mutable backing fields are only used to set value. */
    fun noGetter(): Nothing = fail { NO_GETTER }

    /** Equivalent to [error] but throws [UnsupportedOperationException] instead. */
    inline fun fail(
        lazyMessage: () -> Any = { "Fatal error" }
    ): Nothing = throw UnsupportedOperationException(lazyMessage().toString())
}
package ktfx.internal

/** Ktfx internal class, ignore it. */
public object KtfxInternals {
    /** No getter error message. */
    public const val NO_GETTER: String = "Property does not have a getter."

    /** Some mutable backing fields are only used to set value. */
    public fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)
}

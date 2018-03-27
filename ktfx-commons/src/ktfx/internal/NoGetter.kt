package ktfx.internal

internal const val NO_GETTER = "Property does not have a getter"

/** Some mutable backing fields are only used to set value. */
@PublishedApi internal fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)
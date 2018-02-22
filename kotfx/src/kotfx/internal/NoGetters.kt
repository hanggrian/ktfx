package kotfx.internal

internal const val NO_GETTER: String = "Property does not have a getter"

@PublishedApi
internal fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)
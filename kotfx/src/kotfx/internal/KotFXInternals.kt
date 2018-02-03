package kotfx.internal

object KotFXInternals {
    const val NO_GETTER: String = "Property does not have a getter"

    fun noGetter(): Nothing = throw UnsupportedOperationException(NO_GETTER)
}
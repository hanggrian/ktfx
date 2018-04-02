@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.util.StringConverter
import ktfx.listeners.internal._StringConverter

/** Interface to build [StringConverter] with Kotlin DSL. */
interface StringConverterBuilder<T> {

    /** Convert the object to String. */
    fun toString(listener: (T?) -> String)

    /** Convert String back to object. */
    fun fromString(listener: (String) -> T?)
}

/** Build string converter with Kotlin DSL. */
inline fun <T> stringConverter(
    builder: StringConverterBuilder<T>.() -> Unit
): StringConverter<T> = _StringConverter<T>().apply(builder)
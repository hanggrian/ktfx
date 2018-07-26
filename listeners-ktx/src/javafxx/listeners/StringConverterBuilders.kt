@file:Suppress("NOTHING_TO_INLINE")

package javafxx.listeners

import javafx.util.StringConverter
import javafxx.listeners.internal._StringConverter

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
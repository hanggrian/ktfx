@file:OptIn(ExperimentalContracts::class)
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.util.StringConverter
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Builds new string converter.
 *
 * @param builderAction configure [StringConverterBuilder.toString]
 *   and [StringConverterBuilder.fromString].
 * @return configured string converter.
 * @see kotlin.text.buildString
 */
public inline fun <T> buildStringConverter(
    builderAction: StringConverterBuilder<T>.() -> Unit,
): StringConverter<T> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    return StringConverterBuilder<T>().apply(builderAction).build()
}

/** Receiver for `buildStringConverter` block. */
public class StringConverterBuilder<T> {
    private var format: (T?) -> String = { it?.toString().orEmpty() }
    private var parse: (String) -> T? = { null }

    /** Convert the object to String. */
    public fun toString(listener: (T?) -> String) {
        format = listener
    }

    /** Convert String back to object. */
    public fun fromString(listener: (String) -> T?) {
        parse = listener
    }

    /** Create to native builder. */
    public fun build(): StringConverter<T> =
        object : StringConverter<T>() {
            override fun fromString(value: String): T? = parse(value)

            override fun toString(value: T?): String = format(value)
        }
}

/** Converts the object provided into its string form. */
public inline operator fun <T> StringConverter<T>.invoke(obj: T): String = toString(obj)

/** Converts the string provided into an object defined by the specific converter. */
public inline operator fun <T> StringConverter<T>.get(s: String): T = fromString(s)

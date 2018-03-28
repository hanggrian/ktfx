@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.beans.binding.Bindings.bindBidirectional
import javafx.beans.property.Property
import javafx.beans.property.StringProperty

/**
 * Generates a bidirectional binding (or "bind with inverse") between a
 * `StringProperty` and another property using the specified converter DSL builder for conversion.
 */
inline fun <T> Property<String>.bindBidirectional(
    property: Property<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = bindBidirectional(this, property, stringConverter(converter))

/**
 * Create a bidirectional binding between this `StringProperty` and another
 * arbitrary property. Relies on an implementation of converter DSL builder for conversion.
 */
inline fun <T> StringProperty.bindBidirectional(
    property: Property<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = bindBidirectional(property, stringConverter(converter))
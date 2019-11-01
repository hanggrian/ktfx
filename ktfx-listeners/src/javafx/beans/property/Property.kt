@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.beans.binding.Bindings.bindBidirectional
import javafx.beans.property.Property

/**
 * Generates a bidirectional binding (or "bind with inverse") between a
 * `StringProperty` and another property using the specified converter DSL builder for conversion.
 */
fun <T> Property<String>.bindBidirectional(
    property: Property<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = bindBidirectional(this, property, buildStringConverter(converter))

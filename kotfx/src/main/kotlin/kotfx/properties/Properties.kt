@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.properties

import javafx.beans.property.Property
import javafx.beans.value.ObservableValue

/** Create a unidirection binding for this property with infix statement. */
inline infix fun <T> Property<T>.bind(observable: ObservableValue<out T>) = bind(observable)

/** Create a bidirectional binding between this property and another with infix statement. */
inline infix fun <T> Property<T>.bindBidirectional(other: Property<T>) = bindBidirectional(other)

/** Remove a bidirectional binding between this property and another one with infix statement. */
inline infix fun <T> Property<T>.unbindBidirectional(other: Property<T>) = unbindBidirectional(other)

/** Returns this property as an observable. */
inline fun <T> Property<T>.asObservable(): ObservableValue<T> = this
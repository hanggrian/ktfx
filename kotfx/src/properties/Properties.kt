@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.beans.property.Property
import javafx.beans.value.ObservableValue

/** Create a unidirection binding for this property with infix statement. */
inline infix fun <T> Property<T>.bind(observable: ObservableValue<out T>) = bind(observable)

inline infix fun <T> Property<T>.rebind(observable: ObservableValue<out T>) {
    if (isBound) unbind()
    bind(observable)
}

/** Create a bidirectional binding between this property and another with infix statement. */
inline infix fun <T> Property<T>.bindBidirectional(other: Property<T>) = bindBidirectional(other)

/** Remove a bidirectional binding between this property and another one with infix statement. */
inline infix fun <T> Property<T>.unbindBidirectional(other: Property<T>) = unbindBidirectional(other)

inline fun <T> Property<T>.rebindBidirectional(old: Property<T>, new: Property<T>) {
    unbindBidirectional(old)
    bindBidirectional(new)
}

/** Returns this property as an observable. */
inline fun <T> Property<T>.asObservable(): ObservableValue<T> = this
@file:Suppress("NOTHING_TO_INLINE")

package kfx.beans.property

import javafx.beans.property.FloatProperty
import javafx.beans.property.ReadOnlyFloatProperty
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.value.ObservableValue

/** Wrap this float in modifiable property. */
inline fun Float?.toProperty(): FloatProperty = SimpleFloatProperty(this ?: 0f)

/** Wrap this float in unmodifiable property. */
inline fun Float?.toReadOnlyProperty(): ReadOnlyFloatProperty = ReadOnlyFloatWrapper(this ?: 0f)

/** Returns this float property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun FloatProperty.asObservable(): ObservableValue<Float> = this as ObservableValue<Float>
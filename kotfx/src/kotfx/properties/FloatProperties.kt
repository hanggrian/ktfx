@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.properties

import javafx.beans.property.SimpleFloatProperty
import javafx.beans.value.ObservableValue

/** Wrap this float in modifiable property. */
inline fun Float?.toMutableProperty(): MutableFloatProperty = SimpleFloatProperty(this ?: 0f)

/** Wrap this float in unmodifiable property. */
inline fun Float?.toProperty(): FloatProperty = FloatWrapper(this ?: 0f)

/** Returns this float property as an observable. */
@Suppress("UNCHECKED_CAST")
inline fun FloatProperty.asObservable(): ObservableValue<Float> = this as ObservableValue<Float>
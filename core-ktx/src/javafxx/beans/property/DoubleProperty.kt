@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.property

import javafx.beans.property.DoubleProperty
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.SimpleDoubleProperty

/** Wrap this double in unmodifiable property. */
inline fun Double?.toProperty(): ReadOnlyDoubleProperty = ReadOnlyDoubleWrapper(this ?: 0.0)

/** Wrap this double in modifiable property. */
inline fun Double?.toMutableProperty(): DoubleProperty = SimpleDoubleProperty(this ?: 0.0)
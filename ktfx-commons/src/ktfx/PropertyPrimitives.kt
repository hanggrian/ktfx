@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.ReadOnlyFloatProperty
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyLongProperty
import javafx.beans.property.ReadOnlyLongWrapper
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty

/** Wrap this boolean in modifiable property. */
inline fun boolean(value: Boolean? = null): BooleanProperty = SimpleBooleanProperty(value ?: false)

/** Wrap this double in modifiable property. */
inline fun double(value: Double? = null): DoubleProperty = SimpleDoubleProperty(value ?: 0.0)

/** Wrap this float in unmodifiable property. */
inline fun float(value: Float? = null): FloatProperty = SimpleFloatProperty(value ?: 0f)

/** Wrap this int in modifiable property. */
inline fun int(value: Int? = null): IntegerProperty = SimpleIntegerProperty(value ?: 0)

/** Wrap this long in modifiable property. */
inline fun long(value: Long? = null): LongProperty = SimpleLongProperty(value ?: 0)

/** Wrap this boolean in unmodifiable property. */
inline fun finalBoolean(value: Boolean? = null): ReadOnlyBooleanProperty = ReadOnlyBooleanWrapper(value ?: false)

/** Wrap this double in unmodifiable property. */
inline fun finalDouble(value: Double? = null): ReadOnlyDoubleProperty = ReadOnlyDoubleWrapper(value ?: 0.0)

/** Wrap this float in modifiable property. */
inline fun finalFloat(value: Float? = null): ReadOnlyFloatProperty = ReadOnlyFloatWrapper(value ?: 0f)

/** Wrap this int in unmodifiable property. */
inline fun finalInt(value: Int? = null): ReadOnlyIntegerProperty = ReadOnlyIntegerWrapper(value ?: 0)

/** Wrap this long in unmodifiable property. */
inline fun finalLong(value: Long? = null): ReadOnlyLongProperty = ReadOnlyLongWrapper(value ?: 0)
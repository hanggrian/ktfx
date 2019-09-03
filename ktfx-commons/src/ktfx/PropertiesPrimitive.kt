@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.Property
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
inline fun booleanPropertyOf(value: Boolean? = null): BooleanProperty =
    SimpleBooleanProperty(value ?: false)

/** Wrap this boolean in unmodifiable property. */
inline fun finalBooleanPropertyOf(value: Boolean? = null): ReadOnlyBooleanProperty =
    ReadOnlyBooleanWrapper(value ?: false)

/** Converts this boolean to property. */
inline fun Boolean?.toProperty(): BooleanProperty =
    booleanPropertyOf(this)

/** Converts this boolean to final property. */
inline fun Boolean?.toFinalProperty(): ReadOnlyBooleanProperty =
    finalBooleanPropertyOf(this)

/** Returns [BooleanProperty] that wraps a [Property]. */
inline fun Property<Boolean>.asProperty(): BooleanProperty =
    BooleanProperty.booleanProperty(this)

/** Wrap this double in modifiable property. */
inline fun doublePropertyOf(value: Double? = null): DoubleProperty =
    SimpleDoubleProperty(value ?: 0.0)

/** Wrap this double in unmodifiable property. */
inline fun finalDoublePropertyOf(value: Double? = null): ReadOnlyDoubleProperty =
    ReadOnlyDoubleWrapper(value ?: 0.0)

/** Converts this double to property. */
inline fun Double?.toProperty(): DoubleProperty =
    doublePropertyOf(this)

/** Converts this double to final property. */
inline fun Double?.toFinalProperty(): ReadOnlyDoubleProperty =
    finalDoublePropertyOf(this)

/** Returns [DoubleProperty] that wraps a [Property]. */
inline fun Property<Double>.asProperty(): DoubleProperty =
    DoubleProperty.doubleProperty(this)

/** Wrap this float in unmodifiable property. */
inline fun floatPropertyOf(value: Float? = null): FloatProperty =
    SimpleFloatProperty(value ?: 0f)

/** Wrap this float in modifiable property. */
inline fun finalFloatPropertyOf(value: Float? = null): ReadOnlyFloatProperty =
    ReadOnlyFloatWrapper(value ?: 0f)

/** Converts this float to property. */
inline fun Float?.toProperty(): FloatProperty =
    floatPropertyOf(this)

/** Converts this float to final property. */
inline fun Float?.toFinalProperty(): ReadOnlyFloatProperty =
    finalFloatPropertyOf(this)

/** Returns [FloatProperty] that wraps a [Property]. */
inline fun Property<Float>.asProperty(): FloatProperty =
    FloatProperty.floatProperty(this)

/** Wrap this int in modifiable property. */
inline fun intPropertyOf(value: Int? = null): IntegerProperty =
    SimpleIntegerProperty(value ?: 0)

/** Wrap this int in unmodifiable property. */
inline fun finalIntPropertyOf(value: Int? = null): ReadOnlyIntegerProperty =
    ReadOnlyIntegerWrapper(value ?: 0)

/** Converts this int to property. */
inline fun Int?.toProperty(): IntegerProperty =
    intPropertyOf(this)

/** Converts this int to final property. */
inline fun Int?.toFinalProperty(): ReadOnlyIntegerProperty =
    finalIntPropertyOf(this)

/** Returns [IntegerProperty] that wraps a [Property]. */
inline fun Property<Int>.asProperty(): IntegerProperty =
    IntegerProperty.integerProperty(this)

/** Wrap this long in modifiable property. */
inline fun longPropertyOf(value: Long? = null): LongProperty =
    SimpleLongProperty(value ?: 0)

/** Wrap this long in unmodifiable property. */
inline fun finalLongPropertyOf(value: Long? = null): ReadOnlyLongProperty =
    ReadOnlyLongWrapper(value ?: 0)

/** Converts this long to property. */
inline fun Long?.toProperty(): LongProperty =
    longPropertyOf(this)

/** Converts this long to final property. */
inline fun Long?.toFinalProperty(): ReadOnlyLongProperty =
    finalLongPropertyOf(this)

/** Returns [LongProperty] that wraps a [Property]. */
inline fun Property<Long>.asProperty(): LongProperty =
    LongProperty.longProperty(this)

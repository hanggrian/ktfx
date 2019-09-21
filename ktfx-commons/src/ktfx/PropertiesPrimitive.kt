@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

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
fun Boolean?.asProperty(): BooleanProperty =
    SimpleBooleanProperty(this ?: false)

/** Wrap this boolean in unmodifiable property. */
fun Boolean?.asFinalProperty(): ReadOnlyBooleanProperty =
    ReadOnlyBooleanWrapper(this ?: false)

/** Returns [BooleanProperty] that wraps a [Property]. */
fun Property<Boolean>.unbox(): BooleanProperty =
    BooleanProperty.booleanProperty(this)

/** Wrap this double in modifiable property. */
fun Double?.asProperty(): DoubleProperty =
    SimpleDoubleProperty(this ?: 0.0)

/** Wrap this double in unmodifiable property. */
fun Double?.asFinalProperty(): ReadOnlyDoubleProperty =
    ReadOnlyDoubleWrapper(this ?: 0.0)

/** Returns [DoubleProperty] that wraps a [Property]. */
fun Property<Double>.unbox(): DoubleProperty =
    DoubleProperty.doubleProperty(this)

/** Wrap this float in unmodifiable property. */
fun Float?.asProperty(): FloatProperty =
    SimpleFloatProperty(this ?: 0f)

/** Wrap this float in modifiable property. */
fun Float?.asFinalProperty(): ReadOnlyFloatProperty =
    ReadOnlyFloatWrapper(this ?: 0f)

/** Returns [FloatProperty] that wraps a [Property]. */
fun Property<Float>.unbox(): FloatProperty =
    FloatProperty.floatProperty(this)

/** Wrap this int in modifiable property. */
fun Int?.asProperty(): IntegerProperty =
    SimpleIntegerProperty(this ?: 0)

/** Wrap this int in unmodifiable property. */
fun Int?.asFinalProperty(): ReadOnlyIntegerProperty =
    ReadOnlyIntegerWrapper(this ?: 0)

/** Returns [IntegerProperty] that wraps a [Property]. */
fun Property<Int>.unbox(): IntegerProperty =
    IntegerProperty.integerProperty(this)

/** Wrap this long in modifiable property. */
fun Long?.asProperty(): LongProperty =
    SimpleLongProperty(this ?: 0)

/** Wrap this long in unmodifiable property. */
fun Long?.asFinalProperty(): ReadOnlyLongProperty =
    ReadOnlyLongWrapper(this ?: 0)

/** Returns [LongProperty] that wraps a [Property]. */
fun Property<Long>.unbox(): LongProperty =
    LongProperty.longProperty(this)

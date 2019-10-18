@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.Property
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyLongWrapper
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleLongProperty

/**
 * Wrap nullable boolean in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleBooleanProperty
 * @see ReadOnlyBooleanWrapper
 */
fun Boolean?.asProperty(readOnly: Boolean = false): BooleanProperty {
    val initialValue = this ?: false
    return when {
        readOnly -> ReadOnlyBooleanWrapper(initialValue)
        else -> SimpleBooleanProperty(initialValue)
    }
}

/**
 * Wrap nullable double in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleDoubleProperty
 * @see ReadOnlyDoubleWrapper
 */
fun Double?.asProperty(readOnly: Boolean = false): DoubleProperty {
    val initialValue = this ?: 0.0
    return when {
        readOnly -> ReadOnlyDoubleWrapper(initialValue)
        else -> SimpleDoubleProperty(initialValue)
    }
}

/**
 * Wrap nullable float in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleFloatProperty
 * @see ReadOnlyFloatWrapper
 */
fun Float?.asProperty(readOnly: Boolean = false): FloatProperty {
    val initialValue = this ?: 0f
    return when {
        readOnly -> ReadOnlyFloatWrapper(initialValue)
        else -> SimpleFloatProperty(initialValue)
    }
}

/**
 * Wrap nullable int in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleIntegerProperty
 * @see ReadOnlyIntegerWrapper
 */
fun Int?.asProperty(readOnly: Boolean = false): IntegerProperty {
    val initialValue = this ?: 0
    return when {
        readOnly -> ReadOnlyIntegerWrapper(initialValue)
        else -> SimpleIntegerProperty(initialValue)
    }
}

/**
 * Wrap nullable long in a JavaFX property.
 *
 * @param readOnly true when this is a read-only property, default is false.
 * @see SimpleLongProperty
 * @see ReadOnlyLongWrapper
 */
fun Long?.asProperty(readOnly: Boolean = false): LongProperty {
    val initialValue = this ?: 0L
    return when {
        readOnly -> ReadOnlyLongWrapper(initialValue)
        else -> SimpleLongProperty(initialValue)
    }
}

/** Returns [BooleanProperty] that wraps a [Property]. */
fun Property<Boolean>.unbox(): BooleanProperty =
    BooleanProperty.booleanProperty(this)

/** Returns [DoubleProperty] that wraps a [Property]. */
fun Property<Double>.unbox(): DoubleProperty =
    DoubleProperty.doubleProperty(this)

/** Returns [FloatProperty] that wraps a [Property]. */
fun Property<Float>.unbox(): FloatProperty =
    FloatProperty.floatProperty(this)

/** Returns [IntegerProperty] that wraps a [Property]. */
fun Property<Int>.unbox(): IntegerProperty =
    IntegerProperty.integerProperty(this)

/** Returns [LongProperty] that wraps a [Property]. */
fun Property<Long>.unbox(): LongProperty =
    LongProperty.longProperty(this)

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
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyFloatProperty
import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyLongProperty
import javafx.beans.property.ReadOnlyProperty

/** Revert the effect of [BooleanProperty.asObject]. */
public inline fun Property<Boolean>.asPrimitive(): BooleanProperty =
    BooleanProperty.booleanProperty(this)

/** Revert the effect of [ReadOnlyBooleanProperty.asObject]. */
public inline fun ReadOnlyProperty<Boolean>.asPrimitive(): ReadOnlyBooleanProperty =
    ReadOnlyBooleanProperty.readOnlyBooleanProperty(this)

/** Revert the effect of [DoubleProperty.asObject]. */
public inline fun Property<Double>.asPrimitive(): DoubleProperty =
    DoubleProperty.doubleProperty(this)

/** Revert the effect of [ReadOnlyDoubleProperty.asObject]. */
public inline fun ReadOnlyProperty<Double>.asPrimitive(): ReadOnlyDoubleProperty =
    ReadOnlyDoubleProperty.readOnlyDoubleProperty(this)

/** Revert the effect of [FloatProperty.asObject]. */
public inline fun Property<Float>.asPrimitive(): FloatProperty = FloatProperty.floatProperty(this)

/** Revert the effect of [ReadOnlyFloatProperty.asObject]. */
public inline fun ReadOnlyProperty<Float>.asPrimitive(): ReadOnlyFloatProperty =
    ReadOnlyFloatProperty.readOnlyFloatProperty(this)

/** Revert the effect of [IntegerProperty.asObject]. */
public inline fun Property<Int>.asPrimitive(): IntegerProperty =
    IntegerProperty.integerProperty(this)

/** Revert the effect of [ReadOnlyIntegerProperty.asObject]. */
public inline fun ReadOnlyProperty<Int>.asPrimitive(): ReadOnlyIntegerProperty =
    ReadOnlyIntegerProperty.readOnlyIntegerProperty(this)

/** Revert the effect of [LongProperty.asObject]. */
public inline fun Property<Long>.asPrimitive(): LongProperty = LongProperty.longProperty(this)

/** Revert the effect of [ReadOnlyLongProperty.asObject]. */
public inline fun ReadOnlyProperty<Long>.asPrimitive(): ReadOnlyLongProperty =
    ReadOnlyLongProperty.readOnlyLongProperty(this)

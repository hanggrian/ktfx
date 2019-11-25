@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.Property

/** Revert the effect of [BooleanProperty.asObject]. */
fun Property<Boolean>.asPrimitive(): BooleanProperty = BooleanProperty.booleanProperty(this)

/** Revert the effect of [DoubleProperty.asObject]. */
fun Property<Double>.asPrimitive(): DoubleProperty = DoubleProperty.doubleProperty(this)

/** Revert the effect of [FloatProperty.asObject]. */
fun Property<Float>.asPrimitive(): FloatProperty = FloatProperty.floatProperty(this)

/** Revert the effect of [IntegerProperty.asObject]. */
fun Property<Int>.asPrimitive(): IntegerProperty = IntegerProperty.integerProperty(this)

/** Revert the effect of [LongProperty.asObject]. */
fun Property<Long>.asPrimitive(): LongProperty = LongProperty.longProperty(this)

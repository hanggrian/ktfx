@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.Property

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

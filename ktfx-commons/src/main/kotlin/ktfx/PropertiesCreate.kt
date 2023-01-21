@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.ListProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.MapProperty
import javafx.beans.property.ObjectProperty
import javafx.beans.property.Property
import javafx.beans.property.SetProperty
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleFloatProperty
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleLongProperty
import javafx.beans.property.SimpleMapProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleSetProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.collections.ObservableList
import javafx.collections.ObservableMap
import javafx.collections.ObservableSet

/** Create a [Property] with [initialValue]. */
inline fun <T> propertyOf(initialValue: T? = null): ObjectProperty<T> =
    SimpleObjectProperty<T>(initialValue)

/** Create a [StringProperty] with [initialValue]. */
inline fun stringPropertyOf(initialValue: String? = null): StringProperty =
    SimpleStringProperty(initialValue)

/** Create a [BooleanProperty] with [initialValue]. */
inline fun booleanPropertyOf(initialValue: Boolean = false): BooleanProperty =
    SimpleBooleanProperty(initialValue)

/** Create a [DoubleProperty] with [initialValue]. */
inline fun doublePropertyOf(initialValue: Double = 0.0): DoubleProperty =
    SimpleDoubleProperty(initialValue)

/** Create a [FloatProperty] with [initialValue]. */
inline fun floatPropertyOf(initialValue: Float = 0f): FloatProperty =
    SimpleFloatProperty(initialValue)

/** Create a [LongProperty] with [initialValue]. */
inline fun longPropertyOf(initialValue: Long = 0L): LongProperty =
    SimpleLongProperty(initialValue)

/** Create a [IntegerProperty] with [initialValue]. */
inline fun intPropertyOf(initialValue: Int = 0): IntegerProperty =
    SimpleIntegerProperty(initialValue)

/** Create a [ListProperty] with [initialValue]. */
inline fun <E> listPropertyOf(initialValue: ObservableList<E>? = null): ListProperty<E> =
    SimpleListProperty<E>(initialValue)

/** Create a [SetProperty] with [initialValue]. */
inline fun <E> setPropertyOf(initialValue: ObservableSet<E>? = null): SetProperty<E> =
    SimpleSetProperty<E>(initialValue)

/** Create a [MapProperty] with [initialValue]. */
inline fun <K, V> mapPropertyOf(initialValue: ObservableMap<K, V>? = null): MapProperty<K, V> =
    SimpleMapProperty<K, V>(initialValue)

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

/** Create a [BooleanProperty] with [initialValue]. */
inline fun booleanProperty(initialValue: Boolean = false): BooleanProperty = SimpleBooleanProperty(initialValue)

/** Create a [BooleanProperty] with [initialValue] and [configuration] block. */
inline fun booleanProperty(initialValue: Boolean = false, configuration: BooleanProperty.() -> Unit): BooleanProperty =
    SimpleBooleanProperty(initialValue).apply(configuration)

/** Create a [DoubleProperty] with [initialValue]. */
inline fun doubleProperty(initialValue: Double = 0.0): DoubleProperty = SimpleDoubleProperty(initialValue)

/** Create a [DoubleProperty] with [initialValue] and [configuration] block. */
inline fun doubleProperty(initialValue: Double = 0.0, configuration: DoubleProperty.() -> Unit): DoubleProperty =
    SimpleDoubleProperty(initialValue).apply(configuration)

/** Create a [FloatProperty] with [initialValue]. */
inline fun floatProperty(initialValue: Float = 0f): FloatProperty = SimpleFloatProperty(initialValue)

/** Create a [FloatProperty] with [initialValue] and [configuration] block. */
inline fun floatProperty(initialValue: Float = 0f, configuration: FloatProperty.() -> Unit): FloatProperty =
    SimpleFloatProperty(initialValue).apply(configuration)

/** Create a [IntegerProperty] with [initialValue]. */
inline fun intProperty(initialValue: Int = 0): IntegerProperty = SimpleIntegerProperty(initialValue)

/** Create a [IntegerProperty] with [initialValue] and [configuration] block. */
inline fun intProperty(initialValue: Int = 0, configuration: IntegerProperty.() -> Unit): IntegerProperty =
    SimpleIntegerProperty(initialValue).apply(configuration)

/** Create a [LongProperty] with [initialValue]. */
inline fun longProperty(initialValue: Long = 0L): LongProperty = SimpleLongProperty(initialValue)

/** Create a [LongProperty] with [initialValue] and [configuration] block. */
inline fun longProperty(initialValue: Long = 0L, configuration: LongProperty.() -> Unit): LongProperty =
    SimpleLongProperty(initialValue).apply(configuration)

/** Create a [Property] with [initialValue]. */
inline fun <T> property(initialValue: T? = null): ObjectProperty<T> = SimpleObjectProperty<T>(initialValue)

/** Create a [Property] with [initialValue] and [configuration] block. */
inline fun <T> property(initialValue: T? = null, configuration: ObjectProperty<T>.() -> Unit): ObjectProperty<T> =
    SimpleObjectProperty<T>(initialValue).apply(configuration)

/** Create a [StringProperty] with [initialValue]. */
inline fun stringProperty(initialValue: String? = null): StringProperty = SimpleStringProperty(initialValue)

/** Create a [StringProperty] with [initialValue] and [configuration] block. */
inline fun stringProperty(initialValue: String? = null, configuration: StringProperty.() -> Unit): StringProperty =
    SimpleStringProperty(initialValue).apply(configuration)

/** Create a [ListProperty] with [initialValue]. */
inline fun <E> listProperty(initialValue: ObservableList<E>? = null): ListProperty<E> =
    SimpleListProperty<E>(initialValue)

/** Create a [ListProperty] with [initialValue] and [configuration] block. */
inline fun <E> listProperty(
    initialValue: ObservableList<E>? = null,
    configuration: ListProperty<E>.() -> Unit
): ListProperty<E> = SimpleListProperty<E>(initialValue).apply(configuration)

/** Create a [SetProperty] with [initialValue]. */
inline fun <E> setProperty(initialValue: ObservableSet<E>? = null): SetProperty<E> =
    SimpleSetProperty<E>(initialValue)

/** Create a [SetProperty] with [initialValue] and [configuration] block. */
inline fun <E> setProperty(
    initialValue: ObservableSet<E>? = null,
    configuration: SetProperty<E>.() -> Unit
): SetProperty<E> = SimpleSetProperty<E>(initialValue).apply(configuration)

/** Create a [MapProperty] with [initialValue]. */
inline fun <K, V> mapProperty(initialValue: ObservableMap<K, V>? = null): MapProperty<K, V> =
    SimpleMapProperty<K, V>(initialValue)

/** Create a [MapProperty] with [initialValue] and [configuration] block. */
inline fun <K, V> mapProperty(
    initialValue: ObservableMap<K, V>? = null,
    configuration: MapProperty<K, V>.() -> Unit
): MapProperty<K, V> = SimpleMapProperty<K, V>(initialValue).apply(configuration)

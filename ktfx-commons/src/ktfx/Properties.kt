@file:JvmMultifileClass
@file:JvmName("PropertiesKt")

package ktfx

import javafx.beans.property.BooleanProperty
import javafx.beans.property.DoubleProperty
import javafx.beans.property.FloatProperty
import javafx.beans.property.IntegerProperty
import javafx.beans.property.ListProperty
import javafx.beans.property.LongProperty
import javafx.beans.property.MapProperty
import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.ReadOnlyLongWrapper
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.ReadOnlyStringWrapper
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

/** Wrap nullable object in a property. */
fun <E> propertyOf(initialValue: E? = null): ObjectProperty<E> = SimpleObjectProperty(initialValue)

/** Wrap nullable object in a read-only wrapper property. */
fun <E> wrapperOf(initialValue: E? = null): ReadOnlyObjectWrapper<E> = ReadOnlyObjectWrapper<E>(initialValue)

/** Wrap string in a property. */
fun stringPropertyOf(initialValue: String? = null): StringProperty = SimpleStringProperty(initialValue)

/** Wrap string in a read-only wrapper property. */
fun stringWrapperOf(initialValue: String? = null): ReadOnlyStringWrapper = ReadOnlyStringWrapper(initialValue)

/** Wrap boolean in a property. */
fun booleanPropertyOf(initialValue: Boolean = false): BooleanProperty = SimpleBooleanProperty(initialValue)

/** Wrap boolean in a read-only wrapper property. */
fun booleanWrapperOf(initialValue: Boolean = false): ReadOnlyBooleanWrapper = ReadOnlyBooleanWrapper(initialValue)

/** Wrap double in a property. */
fun doublePropertyOf(initialValue: Double = 0.0): DoubleProperty = SimpleDoubleProperty(initialValue)

/** Wrap double in a read-only wrapper property. */
fun doubleWrapperOf(initialValue: Double = 0.0): ReadOnlyDoubleWrapper = ReadOnlyDoubleWrapper(initialValue)

/** Wrap float in a property. */
fun floatPropertyOf(initialValue: Float = 0f): FloatProperty = SimpleFloatProperty(initialValue)

/** Wrap float in a read-only wrapper property. */
fun floatWrapperOf(initialValue: Float = 0f): ReadOnlyFloatWrapper = ReadOnlyFloatWrapper(initialValue)

/** Wrap int in a property. */
fun intPropertyOf(initialValue: Int = 0): IntegerProperty = SimpleIntegerProperty(initialValue)

/** Wrap int in a read-only wrapper property. */
fun intWrapperOf(initialValue: Int = 0): ReadOnlyIntegerWrapper = ReadOnlyIntegerWrapper(initialValue)

/** Wrap long in a property. */
fun longPropertyOf(initialValue: Long = 0): LongProperty = SimpleLongProperty(initialValue)

/** Wrap long in a read-only wrapper property. */
fun longWrapperOf(initialValue: Long = 0): ReadOnlyLongWrapper = ReadOnlyLongWrapper(initialValue)

/** Wrap list in a property. */
fun <E> listPropertyOf(initialValue: ObservableList<E>? = null): ListProperty<E> = SimpleListProperty(initialValue)

/** Wrap list in a read-only wrapper property. */
fun <E> listWrapperOf(initialValue: ObservableList<E>? = null): ReadOnlyListWrapper<E> =
    ReadOnlyListWrapper(initialValue)

/** Wrap set in a property. */
fun <E> setPropertyOf(initialValue: ObservableSet<E>? = null): SetProperty<E> = SimpleSetProperty(initialValue)

/** Wrap set in a read-only wrapper property. */
fun <E> setWrapperOf(initialValue: ObservableSet<E>? = null): ReadOnlySetWrapper<E> = ReadOnlySetWrapper(initialValue)

/** Wrap map in a property. */
fun <K, V> mapPropertyOf(initialValue: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(initialValue)

/** Wrap map in a read-only wrapper property. */
fun <K, V> mapWrapperOf(initialValue: ObservableMap<K, V>? = null): ReadOnlyMapWrapper<K, V> =
    ReadOnlyMapWrapper(initialValue)

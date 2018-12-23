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
import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.property.ReadOnlyDoubleProperty
import javafx.beans.property.ReadOnlyDoubleWrapper
import javafx.beans.property.ReadOnlyFloatProperty
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.ReadOnlyLongProperty
import javafx.beans.property.ReadOnlyLongWrapper
import javafx.beans.property.ReadOnlyMapProperty
import javafx.beans.property.ReadOnlyMapWrapper
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlySetProperty
import javafx.beans.property.ReadOnlySetWrapper
import javafx.beans.property.ReadOnlyStringProperty
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
import ktfx.collections.emptyObservableList
import ktfx.collections.emptyObservableMap
import ktfx.collections.emptyObservableSet
import ktfx.collections.mutableObservableListOf
import ktfx.collections.mutableObservableMapOf
import ktfx.collections.mutableObservableSetOf
import ktfx.collections.observableListOf
import ktfx.collections.observableMapOf
import ktfx.collections.observableSetOf

/** Wrap this object in modifiable property. */
inline fun <E> propertyOf(value: E? = null): ObjectProperty<E> = SimpleObjectProperty(value)

/** Wrap this object in unmodifiable property. */
inline fun <E> readOnlyPropertyOf(value: E? = null): ReadOnlyObjectProperty<E> = ReadOnlyObjectWrapper(value)

/** Wrap this boolean in modifiable property. */
inline fun booleanPropertyOf(value: Boolean? = null): BooleanProperty = SimpleBooleanProperty(value ?: false)

/** Wrap this boolean in unmodifiable property. */
inline fun readOnlyBooleanPropertyOf(value: Boolean? = null): ReadOnlyBooleanProperty =
    ReadOnlyBooleanWrapper(value ?: false)

/** Wrap this double in modifiable property. */
inline fun doublePropertyOf(value: Double? = null): DoubleProperty = SimpleDoubleProperty(value ?: 0.0)

/** Wrap this double in unmodifiable property. */
inline fun readOnlyDoublePropertyOf(value: Double? = null): ReadOnlyDoubleProperty = ReadOnlyDoubleWrapper(value ?: 0.0)

/** Wrap this float in unmodifiable property. */
inline fun floatPropertyOf(value: Float? = null): FloatProperty = SimpleFloatProperty(value ?: 0f)

/** Wrap this float in modifiable property. */
inline fun readOnlyFloatPropertyOf(value: Float? = null): ReadOnlyFloatProperty = ReadOnlyFloatWrapper(value ?: 0f)

/** Wrap this int in modifiable property. */
inline fun intPropertyOf(value: Int? = null): IntegerProperty = SimpleIntegerProperty(value ?: 0)

/** Wrap this int in unmodifiable property. */
inline fun readOnlyIntPropertyOf(value: Int? = null): ReadOnlyIntegerProperty = ReadOnlyIntegerWrapper(value ?: 0)

/** Wrap this long in modifiable property. */
inline fun longPropertyOf(value: Long? = null): LongProperty = SimpleLongProperty(value ?: 0)

/** Wrap this long in unmodifiable property. */
inline fun readOnlyLongPropertyOf(value: Long? = null): ReadOnlyLongProperty = ReadOnlyLongWrapper(value ?: 0)

/** Wrap this string in modifiable property. */
inline fun stringPropertyOf(value: String? = null): StringProperty = SimpleStringProperty(value)

/** Wrap this string in unmodifiable property. */
inline fun readOnlyStringPropertyOf(value: String? = null): ReadOnlyStringProperty = ReadOnlyStringWrapper(value)

/** Wrap this list in modifiable property. */
inline fun <E> listPropertyOf(list: ObservableList<E>): ListProperty<E> = SimpleListProperty(list)

inline fun <E> listPropertyOf(vararg items: E): ListProperty<E> = listPropertyOf(mutableObservableListOf(*items))

inline fun <E> listPropertyOf(item: E): ListProperty<E> = listPropertyOf(mutableObservableListOf(item))

inline fun <E> listPropertyOf(): ListProperty<E> = listPropertyOf(mutableObservableListOf())

/** Wrap this list in unmodifiable property. */
inline fun <E> readOnlyListPropertyOf(list: ObservableList<E>): ReadOnlyListProperty<E> = ReadOnlyListWrapper(list)

inline fun <E> readOnlyListPropertyOf(vararg items: E): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(observableListOf(*items))

inline fun <E> readOnlyListPropertyOf(item: E): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(observableListOf(item))

inline fun <E> readOnlyListPropertyOf(): ReadOnlyListProperty<E> =
    readOnlyListPropertyOf(emptyObservableList())

/** Wrap this list in modifiable property. */
inline fun <E> setPropertyOf(set: ObservableSet<E>): SetProperty<E> = SimpleSetProperty(set)

inline fun <E> setPropertyOf(vararg items: E): SetProperty<E> = setPropertyOf(mutableObservableSetOf(*items))

/** Wrap this list in unmodifiable property. */
inline fun <E> readOnlySetPropertyOf(set: ObservableSet<E>): ReadOnlySetProperty<E> = ReadOnlySetWrapper(set)

inline fun <E> readOnlySetPropertyOf(vararg items: E): ReadOnlySetProperty<E> =
    readOnlySetPropertyOf(observableSetOf(*items))

inline fun <E> readOnlySetPropertyOf(): ReadOnlySetProperty<E> =
    readOnlySetPropertyOf(emptyObservableSet())

/** Wrap this map in modifiable property. */
inline fun <K, V> mapPropertyOf(map: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(map)

inline fun <K, V> mapPropertyOf(vararg pairs: Pair<K, V>): MapProperty<K, V> =
    mapPropertyOf(mutableObservableMapOf(*pairs))

/** Wrap this map in unmodifiable property. */
inline fun <K, V> readOnlyMapPropertyOf(map: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> =
    ReadOnlyMapWrapper(map)

inline fun <K, V> readOnlyMapPropertyOf(vararg pairs: Pair<K, V>): ReadOnlyMapProperty<K, V> =
    readOnlyMapPropertyOf(observableMapOf(*pairs))

inline fun <K, V> readOnlyMapPropertyOf(): ReadOnlyMapProperty<K, V> =
    readOnlyMapPropertyOf(emptyObservableMap())
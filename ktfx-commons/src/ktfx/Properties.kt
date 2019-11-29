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

/** Wrap nullable object in a property. */
fun <E> propertyOf(value: E? = null): ObjectProperty<E> = SimpleObjectProperty(value)

/** Wrap nullable object in a read-only property. */
fun <E> finalPropertyOf(value: E? = null): ReadOnlyObjectProperty<E> = ReadOnlyObjectWrapper(value)

/** Wrap nullable boolean in a property. */
fun booleanPropertyOf(value: Boolean? = null): BooleanProperty = SimpleBooleanProperty(value ?: false)

/** Wrap nullable boolean in a read-only property. */
fun finalBooleanPropertyOf(value: Boolean? = null): ReadOnlyBooleanProperty = ReadOnlyBooleanWrapper(value ?: false)

/** Wrap nullable double in a property. */
fun doublePropertyOf(value: Double? = null): DoubleProperty = SimpleDoubleProperty(value ?: 0.0)

/** Wrap nullable double in a read-only property. */
fun finalDoublePropertyOf(value: Double? = null): ReadOnlyDoubleProperty = ReadOnlyDoubleWrapper(value ?: 0.0)

/** Wrap nullable float in a property. */
fun floatPropertyOf(value: Float? = null): FloatProperty = SimpleFloatProperty(value ?: 0f)

/** Wrap nullable float in a read-only property. */
fun finalFloatPropertyOf(value: Float? = null): ReadOnlyFloatProperty = ReadOnlyFloatWrapper(value ?: 0f)

/** Wrap nullable int in a property. */
fun intPropertyOf(value: Int? = null): IntegerProperty = SimpleIntegerProperty(value ?: 0)

/** Wrap nullable int in a read-only property. */
fun finalIntPropertyOf(value: Int? = null): ReadOnlyIntegerProperty = ReadOnlyIntegerWrapper(value ?: 0)

/** Wrap nullable long in a property. */
fun longPropertyOf(value: Long? = null): LongProperty = SimpleLongProperty(value ?: 0)

/** Wrap nullable long in a read-only property. */
fun finalLongPropertyOf(value: Long? = null): ReadOnlyLongProperty = ReadOnlyLongWrapper(value ?: 0)

/** Wrap nullable string in a property. */
fun stringPropertyOf(value: String? = null): StringProperty = SimpleStringProperty(value)

/** Wrap nullable string in a read-only property. */
fun finalStringPropertyOf(value: String? = null): ReadOnlyStringProperty = ReadOnlyStringWrapper(value)

/** Wrap nullable list in a property. */
fun <E> listPropertyOf(value: ObservableList<E>? = null): ListProperty<E> = SimpleListProperty(value)

/** Wrap nullable list in a read-only property. */
fun <E> finalListPropertyOf(value: ObservableList<E>? = null): ReadOnlyListProperty<E> = ReadOnlyListWrapper(value)

/** Wrap nullable set in a property. */
fun <E> setPropertyOf(value: ObservableSet<E>? = null): SetProperty<E> = SimpleSetProperty(value)

/** Wrap nullable set in a read-only property. */
fun <E> finalSetPropertyOf(value: ObservableSet<E>? = null): ReadOnlySetProperty<E> = ReadOnlySetWrapper(value)

/** Wrap nullable map in a property. */
fun <K, V> mapPropertyOf(value: ObservableMap<K, V>? = null): MapProperty<K, V> = SimpleMapProperty(value)

/** Wrap nullable map in a read-only property. */
fun <K, V> finalMapPropertyOf(value: ObservableMap<K, V>? = null): ReadOnlyMapProperty<K, V> = ReadOnlyMapWrapper(value)

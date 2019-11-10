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

/** Wrap nullable list in a property. */
fun <E> listProperty(value: ObservableList<E>?): ListProperty<E> =
    SimpleListProperty(value)

/** Wrap nullable list in a read-only property. */
fun <E> finalListProperty(value: ObservableList<E>?): ListProperty<E> =
    ReadOnlyListWrapper(value)

/** Wrap nullable set in a property. */
fun <E> setProperty(value: ObservableSet<E>?): SetProperty<E> =
    SimpleSetProperty(value)

/** Wrap nullable object in a property. */
fun <E> property(value: E?): ObjectProperty<E> =
    SimpleObjectProperty(value)

/** Wrap nullable object in a read-only property. */
fun <E> finalProperty(value: E?): ObjectProperty<E> =
    ReadOnlyObjectWrapper(value)

/** Wrap nullable set in a read-only property. */
fun <E> finalSetProperty(value: ObservableSet<E>?): SetProperty<E> =
    ReadOnlySetWrapper(value)

/** Wrap nullable map in a property. */
fun <K, V> mapProperty(value: ObservableMap<K, V>?): MapProperty<K, V> =
    SimpleMapProperty(value)

/** Wrap nullable map in a read-only property. */
fun <K, V> finalMapProperty(value: ObservableMap<K, V>?): MapProperty<K, V> =
    ReadOnlyMapWrapper(value)

/** Wrap nullable string in a property. */
fun stringProperty(value: String?): StringProperty =
    SimpleStringProperty(value)

/** Wrap nullable string in a read-only property. */
fun finalStringProperty(value: String?): StringProperty =
    ReadOnlyStringWrapper(value)

/** Wrap nullable boolean in a property. */
fun booleanProperty(value: Boolean?): BooleanProperty =
    SimpleBooleanProperty(value ?: false)

/** Wrap nullable boolean in a read-only property. */
fun finalBooleanProperty(value: Boolean?): BooleanProperty =
    ReadOnlyBooleanWrapper(value ?: false)

/** Wrap nullable double in a property. */
fun doubleProperty(value: Double?): DoubleProperty =
    SimpleDoubleProperty(value ?: 0.0)

/** Wrap nullable double in a read-only property. */
fun finalDoubleProperty(value: Double?): DoubleProperty =
    ReadOnlyDoubleWrapper(value ?: 0.0)

/** Wrap nullable float in a property. */
fun floatProperty(value: Float?): FloatProperty =
    SimpleFloatProperty(value ?: 0f)

/** Wrap nullable float in a read-only property. */
fun finalDoubleProperty(value: Float?): FloatProperty =
    ReadOnlyFloatWrapper(value ?: 0f)

/** Wrap nullable int in a property. */
fun intProperty(value: Int?): IntegerProperty =
    SimpleIntegerProperty(value ?: 0)

/** Wrap nullable int in a read-only property. */
fun finalIntProperty(value: Int?): IntegerProperty =
    ReadOnlyIntegerWrapper(value ?: 0)

/** Wrap nullable long in a property. */
fun longProperty(value: Long?): LongProperty =
    SimpleLongProperty(value ?: 0)

/** Wrap nullable long in a read-only property. */
fun finalLongProperty(value: Long?): LongProperty =
    ReadOnlyLongWrapper(value ?: 0)

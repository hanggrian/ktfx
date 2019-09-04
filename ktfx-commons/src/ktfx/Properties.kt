@file:JvmMultifileClass
@file:JvmName("PropertiesKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx

import javafx.beans.property.ObjectProperty
import javafx.beans.property.ReadOnlyObjectProperty
import javafx.beans.property.ReadOnlyObjectWrapper
import javafx.beans.property.ReadOnlyStringProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

/** Wrap this object in modifiable property. */
fun <E> propertyOf(value: E? = null): ObjectProperty<E> =
    SimpleObjectProperty(value)

/** Wrap this object in unmodifiable property. */
fun <E> finalPropertyOf(value: E? = null): ReadOnlyObjectProperty<E> =
    ReadOnlyObjectWrapper(value)

/** Converts this object to property. */
inline fun <E> E?.toProperty(): ObjectProperty<E> =
    propertyOf(this)

/** Converts this object to final property. */
inline fun <E> E?.toFinalProperty(): ReadOnlyObjectProperty<E> =
    finalPropertyOf(this)

/** Wrap this string in modifiable property. */
fun stringPropertyOf(value: String? = null): StringProperty =
    SimpleStringProperty(value)

/** Wrap this string in unmodifiable property. */
fun finalStringPropertyOf(value: String? = null): ReadOnlyStringProperty =
    ReadOnlyStringWrapper(value)

/** Converts this string to property. */
inline fun String?.toProperty(): StringProperty =
    stringPropertyOf(this)

/** Converts this string to final property. */
inline fun String?.toFinalProperty(): ReadOnlyStringProperty =
    finalStringPropertyOf(this)

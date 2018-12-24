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
inline fun <E> propertyOf(value: E? = null): ObjectProperty<E> = SimpleObjectProperty(value)

/** Wrap this string in modifiable property. */
inline fun stringPropertyOf(value: String? = null): StringProperty = SimpleStringProperty(value)

/** Wrap this object in unmodifiable property. */
inline fun <E> readOnlyPropertyOf(value: E? = null): ReadOnlyObjectProperty<E> = ReadOnlyObjectWrapper(value)

/** Wrap this string in unmodifiable property. */
inline fun readOnlyStringPropertyOf(value: String? = null): ReadOnlyStringProperty = ReadOnlyStringWrapper(value)
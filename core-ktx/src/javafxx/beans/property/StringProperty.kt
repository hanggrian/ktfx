@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.property

import javafx.beans.property.ReadOnlyStringProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

/** Wrap this string in unmodifiable property. */
inline fun String?.toProperty(): ReadOnlyStringProperty = ReadOnlyStringWrapper(this)

/** Wrap this string in modifiable property. */
inline fun String?.toMutableProperty(): StringProperty = SimpleStringProperty(this)
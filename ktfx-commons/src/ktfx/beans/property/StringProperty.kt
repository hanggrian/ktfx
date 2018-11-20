@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.ReadOnlyStringProperty
import javafx.beans.property.ReadOnlyStringWrapper
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty

/** Wrap this string in unmodifiable property. */
inline fun String?.asReadOnlyProperty(): ReadOnlyStringProperty = ReadOnlyStringWrapper(this)

/** Wrap this string in modifiable property. */
inline fun String?.asProperty(): StringProperty = SimpleStringProperty(this)
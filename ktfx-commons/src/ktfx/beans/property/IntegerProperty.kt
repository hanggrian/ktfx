@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.IntegerProperty
import javafx.beans.property.ReadOnlyIntegerProperty
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.beans.property.SimpleIntegerProperty

/** Wrap this int in unmodifiable property. */
inline fun Int?.asReadOnlyProperty(): ReadOnlyIntegerProperty = ReadOnlyIntegerWrapper(this ?: 0)

/** Wrap this int in modifiable property. */
inline fun Int?.asProperty(): IntegerProperty = SimpleIntegerProperty(this ?: 0)
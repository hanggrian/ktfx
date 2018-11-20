@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.BooleanProperty
import javafx.beans.property.ReadOnlyBooleanProperty
import javafx.beans.property.ReadOnlyBooleanWrapper
import javafx.beans.property.SimpleBooleanProperty

/** Wrap this boolean in unmodifiable property. */
inline fun Boolean?.asReadOnlyProperty(): ReadOnlyBooleanProperty = ReadOnlyBooleanWrapper(this ?: false)

/** Wrap this boolean in modifiable property. */
inline fun Boolean?.asProperty(): BooleanProperty = SimpleBooleanProperty(this ?: false)
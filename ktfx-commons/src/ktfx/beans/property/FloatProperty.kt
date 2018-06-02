@file:Suppress("NOTHING_TO_INLINE")

package ktfx.beans.property

import javafx.beans.property.FloatProperty
import javafx.beans.property.ReadOnlyFloatProperty
import javafx.beans.property.ReadOnlyFloatWrapper
import javafx.beans.property.SimpleFloatProperty

/** Wrap this float in unmodifiable property. */
inline fun Float?.toProperty(): ReadOnlyFloatProperty = ReadOnlyFloatWrapper(this ?: 0f)

/** Wrap this float in modifiable property. */
inline fun Float?.toMutableProperty(): FloatProperty = SimpleFloatProperty(this ?: 0f)
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners.internal

import javafx.util.StringConverter
import kotfx.listeners._StringConverter

inline fun <T> (_StringConverter<T>.() -> Unit).asConverter(): StringConverter<T> = _StringConverter<T>().apply(this)
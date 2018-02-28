@file:Suppress("NOTHING_TO_INLINE")

package kotfx.internal

import javafx.util.StringConverter
import kotfx.util._StringConverter

inline fun <T> (_StringConverter<T>.() -> Unit).asConverter(): StringConverter<T> = _StringConverter<T>().apply(this)
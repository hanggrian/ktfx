@file:Suppress("NOTHING_TO_INLINE")

package kotfx.internal

import kotfx._StringConverter

inline fun <T> (_StringConverter<T>.() -> Unit).asConverter() = _StringConverter<T>().apply(this)
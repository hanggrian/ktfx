@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Spinner
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun <T> spinner(
        noinline init: ((@ControlDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.spinner(
        noinline init: ((@ControlDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
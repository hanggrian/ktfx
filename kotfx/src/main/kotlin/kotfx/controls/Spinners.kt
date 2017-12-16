@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Spinner
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun <T> spinnerOf(
        noinline init: ((@ControlDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.spinner(
        noinline init: ((@ControlDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.spinner(
        noinline init: ((@ControlDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
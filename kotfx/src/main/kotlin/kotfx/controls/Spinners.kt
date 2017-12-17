@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Spinner
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.KotfxDsl

@JvmOverloads
inline fun <T> spinner(
        noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }

@JvmOverloads
inline fun <T> ChildManager.spinner(
        noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun <T> ItemManager.spinner(
        noinline init: ((@KotfxDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().apply { init?.invoke(this) }.add()
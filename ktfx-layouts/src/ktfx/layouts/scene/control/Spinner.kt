@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.Spinner

/** Creates a [Spinner]. */
fun <T> spinner(
    init: ((@LayoutMarker Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().also { init?.invoke(it) }

/** Creates a [Spinner] and add it to this manager. */
inline fun <T> NodeManager.spinner(
    noinline init: ((@LayoutMarker Spinner<T>).() -> Unit)? = null
): Spinner<T> = ktfx.layouts.spinner(init).add()
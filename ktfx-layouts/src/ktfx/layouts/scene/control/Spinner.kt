@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Spinner

/** Add a [Spinner] to this manager. */
fun <T> NodeManager.spinner(): Spinner<T> =
    Spinner<T>().add()

/** Add a [Spinner] with initialization block to this manager. */
inline fun <T> NodeManager.spinner(
    init: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> = spinner<T>().apply(init)

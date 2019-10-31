@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Spinner

/** Create a [Spinner] with initialization block. */
inline fun <T> spinner(
    init: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> = Spinner<T>().apply(init)

/** Add a [Spinner] to this manager. */
fun <T> NodeManager.spinner(): Spinner<T> =
    addNode(Spinner())

/** Add a [Spinner] with initialization block to this manager. */
inline fun <T> NodeManager.spinner(
    init: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> = addNode(Spinner(), init)

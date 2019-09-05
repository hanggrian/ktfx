@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListCell
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXListCell] to this manager. */
fun <T> NodeManager.jfxListCell(): JFXListCell<T> =
    JFXListCell<T>().add()

/** Add a [JFXListCell] with initialization to this manager. */
inline fun <T> NodeManager.jfxListCell(
    init: (@LayoutDslMarker JFXListCell<T>).() -> Unit
): JFXListCell<T> = jfxListCell<T>().apply(init)

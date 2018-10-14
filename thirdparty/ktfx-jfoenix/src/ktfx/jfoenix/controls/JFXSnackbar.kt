@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXSnackbar
import javafx.scene.layout.Pane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [JFXSnackbar]. */
fun jfxSnackbar(
    snackbarContainer: Pane? = null,
    init: ((@LayoutDsl JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = JFXSnackbar(snackbarContainer).also { init?.invoke(it) }

/** Creates a [JFXSnackbar] and add it to this manager. */
inline fun NodeManager.jfxSnackbar(
    snackbarContainer: Pane? = null,
    noinline init: ((@LayoutDsl JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = ktfx.jfoenix.jfxSnackbar(snackbarContainer, init)()
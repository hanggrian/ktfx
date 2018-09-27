@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSnackbar
import javafx.scene.Node
import javafx.scene.layout.Pane
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXSnackbar]. */
fun jfxSnackbar(
    snackbarContainer: Pane? = null,
    init: ((@LayoutDsl JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = JFXSnackbar(snackbarContainer).also {
    init?.invoke(it)
}

/** Creates a [JFXSnackbar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxSnackbar(
    snackbarContainer: Pane? = null,
    noinline init: ((@LayoutDsl JFXSnackbar).() -> Unit)? = null
): JFXSnackbar = ktfx.jfoenix.jfxSnackbar(snackbarContainer, init)()
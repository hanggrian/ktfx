@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSnackbar
import javafx.event.ActionEvent
import javafx.scene.layout.Pane

/** Create and show a snackbar. */
inline fun Pane.snackbar(
    text: String,
    timeout: Long
): JFXSnackbar = JFXSnackbar(this).apply { show(text, timeout) }

/** Create and show a snackbar with action. */
inline fun Pane.snackbar(
    text: String,
    timeout: Long,
    actionText: String,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, actionText, timeout, action) }

/** Create and show an indefinite snackbar. */
inline fun Pane.indefiniteSnackbar(
    text: String
): JFXSnackbar = JFXSnackbar(this).apply { show(text, -1) }

/** Create and show an indefinite snackbar with action. */
inline fun Pane.indefiniteSnackbar(
    text: String,
    actionText: String,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, actionText, -1, action) }
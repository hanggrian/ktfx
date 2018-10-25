@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSnackbar
import javafx.event.ActionEvent
import javafx.scene.layout.Pane

/** Taken from `androidx.design.widget.SnackbarManager`. */
@PublishedApi
internal object SnackbarDuration {
    const val SHORT = 1500L
    const val LONG = 2750L
    const val INDEFINITE = -1L
}

/** Create and show a snackbar. */
inline fun Pane.jfxSnackbar(
    text: String
): JFXSnackbar = JFXSnackbar(this).apply { show(text, SnackbarDuration.SHORT) }

/** Create and show a snackbar with action. */
inline fun Pane.jfxSnackbar(
    text: String,
    actionText: String,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, actionText, SnackbarDuration.SHORT, action) }

/** Create and show a long snackbar. */
inline fun Pane.jfxLongSnackbar(
    text: String
): JFXSnackbar = JFXSnackbar(this).apply { show(text, SnackbarDuration.LONG) }

/** Create and show a long snackbar with action. */
inline fun Pane.jfxLongSnackbar(
    text: String,
    actionText: String,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, actionText, SnackbarDuration.LONG, action) }

/** Create and show an indefinite snackbar. */
inline fun Pane.jfxIndefiniteSnackbar(
    text: String
): JFXSnackbar = JFXSnackbar(this).apply { show(text, SnackbarDuration.INDEFINITE) }

/** Create and show an indefinite snackbar with action. */
inline fun Pane.jfxIndefiniteSnackbar(
    text: String,
    actionText: String,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, actionText, SnackbarDuration.INDEFINITE, action) }
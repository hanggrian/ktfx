@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXSnackbar
import javafx.event.ActionEvent
import javafx.scene.layout.Pane

/** Show this snackbar with an action. */
fun JFXSnackbar.show(
    text: String,
    duration: Long,
    actionText: String?,
    action: ((ActionEvent) -> Unit)? = null
): Unit = show(text, actionText, duration) {
    close()
    action?.invoke(it)
}

/** Show this snackbar with an action indefinitely. */
inline fun JFXSnackbar.showIndefinite(
    text: String,
    actionText: String?,
    noinline action: ((ActionEvent) -> Unit)? = null
): Unit = show(text, -1, actionText, action)

/** Show this snackbar indefinitely. */
inline fun JFXSnackbar.showIndefinite(text: String): Unit =
    showIndefinite(text, null, null)

/** Create and show a snackbar with an action. */
fun Pane.jfxSnackbar(
    text: String,
    duration: Long,
    actionText: String?,
    action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = JFXSnackbar(this).apply { show(text, duration, actionText, action) }

/** Create and show a snackbar. */
inline fun Pane.jfxSnackbar(
    text: String,
    duration: Long
): JFXSnackbar = jfxSnackbar(text, duration, null, null)

/** Create and show a snackbar with an action indefinitely. */
inline fun Pane.jfxIndefiniteSnackbar(
    text: String,
    actionText: String?,
    noinline action: ((ActionEvent) -> Unit)? = null
): JFXSnackbar = jfxSnackbar(text, -1, actionText, action)

/** Create and show a snackbar indefinitely. */
inline fun Pane.jfxIndefiniteSnackbar(
    text: String
): JFXSnackbar = jfxIndefiniteSnackbar(text, null, null)

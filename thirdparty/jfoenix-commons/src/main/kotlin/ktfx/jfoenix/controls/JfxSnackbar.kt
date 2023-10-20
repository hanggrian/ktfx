@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXSnackbar
import com.jfoenix.controls.JFXSnackbarLayout
import javafx.event.ActionEvent
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.util.Duration

/** Show this snackbar with custom layout. */
inline fun JFXSnackbar.show(content: Node, duration: Duration): Unit =
    enqueue(JFXSnackbar.SnackbarEvent(content, duration))

/** Show this snackbar with default layout. */
fun JFXSnackbar.show(
    message: String,
    duration: Duration,
    actionText: String? = null,
    action: ((ActionEvent) -> Unit)? = null,
): Unit =
    show(
        JFXSnackbarLayout(message, actionText) {
            close()
            action?.invoke(it)
        },
        duration,
    )

/** Show this snackbar indefinitely with custom layout. */
inline fun JFXSnackbar.showIndefinite(content: Node): Unit =
    enqueue(JFXSnackbar.SnackbarEvent(content, Duration.INDEFINITE))

/** Show this snackbar indefinitely with default layout. */
fun JFXSnackbar.showIndefinite(
    message: String,
    actionText: String? = null,
    action: ((ActionEvent) -> Unit)? = null,
): Unit =
    showIndefinite(
        JFXSnackbarLayout(message, actionText) {
            close()
            action?.invoke(it)
        },
    )

/** Create and show a snackbar with custom layout. */
fun Pane.jfxSnackbar(content: Node, duration: Duration): JFXSnackbar =
    JFXSnackbar(this).apply { show(content, duration) }

/** Create and show a snackbar with default layout. */
fun Pane.jfxSnackbar(
    message: String,
    duration: Duration,
    actionText: String? = null,
    action: ((ActionEvent) -> Unit)? = null,
): JFXSnackbar = JFXSnackbar(this).apply { show(message, duration, actionText, action) }

/** Create and show an indefinite snackbar with custom layout. */
fun Pane.jfxIndefiniteSnackbar(content: Node): JFXSnackbar =
    JFXSnackbar(this).apply { showIndefinite(content) }

/** Create and show an indefinite snackbar with default layout. */
fun Pane.jfxIndefiniteSnackbar(
    message: String,
    actionText: String? = null,
    action: ((ActionEvent) -> Unit)? = null,
): JFXSnackbar = JFXSnackbar(this).apply { showIndefinite(message, actionText, action) }

@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXSnackbar
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.util.Duration
import ktfx.time.milliseconds

/** Show this snackbar with an action. */
fun JFXSnackbar.show(content: Node, duration: Duration): Unit =
    enqueue(JFXSnackbar.SnackbarEvent(content, duration))

/** Show this snackbar with an action indefinitely. */
inline fun JFXSnackbar.showIndefinite(content: Node): Unit =
    show(content, (-1.0).milliseconds)

/** Create and show a snackbar with an action. */
fun Pane.jfxSnackbar(content: Node, duration: Duration): JFXSnackbar =
    JFXSnackbar(this).apply { show(content, duration) }

/** Create and show a snackbar with an action indefinitely. */
inline fun Pane.jfxIndefiniteSnackbar(content: Node): JFXSnackbar =
    jfxSnackbar(content, (-1.0).milliseconds)

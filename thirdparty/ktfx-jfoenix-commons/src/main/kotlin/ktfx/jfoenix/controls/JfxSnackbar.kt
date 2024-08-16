@file:Suppress("NOTHING_TO_INLINE")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.controls

import com.jfoenix.controls.JFXSnackbar
import com.jfoenix.controls.JFXSnackbarLayout
import javafx.event.ActionEvent
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.util.Duration
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Show this snackbar with custom layout. */
public inline fun JFXSnackbar.show(content: Node, duration: Duration): Unit =
    enqueue(JFXSnackbar.SnackbarEvent(content, duration))

/** Show this snackbar with default layout. */
public fun JFXSnackbar.show(
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
public inline fun JFXSnackbar.showIndefinite(content: Node): Unit =
    enqueue(JFXSnackbar.SnackbarEvent(content, Duration.INDEFINITE))

/** Show this snackbar indefinitely with default layout. */
public fun JFXSnackbar.showIndefinite(
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

/** Create a JFoenix snackbar. */
public inline val Pane.jfxSnackbar: JFXSnackbar get() = JFXSnackbar(this)

/**
 * Create a JFoenix snackbar.
 *
 * @param configuration custom snackbar action.
 */
public inline fun Pane.jfxSnackbar(configuration: JFXSnackbar.() -> Unit): JFXSnackbar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return jfxSnackbar.apply(configuration)
}

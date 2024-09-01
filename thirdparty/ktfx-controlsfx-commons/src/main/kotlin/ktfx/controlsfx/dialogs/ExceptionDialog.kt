@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.dialogs

import javafx.scene.control.ButtonType
import org.controlsfx.dialog.ExceptionDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Build an exception dialog with Kotlin DSL.
 *
 * @param exception message to show.
 * @param configuration custom dialog action.
 * @return selected dialog button.
 */
public inline fun exceptionDialog(
    exception: Throwable,
    configuration: ExceptionDialog.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ExceptionDialog(exception)
        .apply(configuration)
        .showAndWait()
}

@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.dialogs

import javafx.scene.control.ButtonType
import org.controlsfx.dialog.CommandLinksDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Build a command links dialog.
 *
 * @param links actual buttons.
 * @param configuration custom dialog action.
 * @return selected dialog button.
 */
public inline fun commandLinksDialog(
    vararg links: CommandLinksDialog.CommandLinksButtonType,
    configuration: CommandLinksDialog.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CommandLinksDialog(*links)
        .apply(configuration)
        .showAndWait()
}

/**
 * Build a command links dialog.
 *
 * @param links actual buttons.
 * @param configuration custom dialog action.
 * @return selected dialog button.
 */
public inline fun commandLinksDialog(
    links: List<CommandLinksDialog.CommandLinksButtonType>,
    configuration: CommandLinksDialog.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return CommandLinksDialog(links)
        .apply(configuration)
        .showAndWait()
}

@file:OptIn(ExperimentalContracts::class)

package ktfx.dialogs

import javafx.scene.control.TextInputDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Show a text input dialog.
 *
 * @param prefill default text.
 * @param configuration custom dialog action.
 * @return input text.
 */
public inline fun inputDialog(
    prefill: String = "",
    configuration: TextInputDialog.() -> Unit,
): Optional<String> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return TextInputDialog(prefill)
        .apply(configuration)
        .showAndWait()
}

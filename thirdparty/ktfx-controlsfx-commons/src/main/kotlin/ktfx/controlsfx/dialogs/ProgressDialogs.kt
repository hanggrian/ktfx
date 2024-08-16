@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.dialogs

import javafx.concurrent.Worker
import org.controlsfx.dialog.ProgressDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Build a progress dialog.
 *
 * @param worker progress worker.
 * @param configuration custom dialog action.
 * @return nothing.
 */
public inline fun progressDialog(
    worker: Worker<*>?,
    configuration: ProgressDialog.() -> Unit,
): Optional<Void> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ProgressDialog(worker)
        .apply(configuration)
        .showAndWait()
}

@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.dialogs

import com.jfoenix.controls.JFXAlert
import javafx.stage.Stage
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Show a JFoenix alert.
 *
 * @param configuration custom dialog action.
 * @return dialog result.
 */
public fun <T> Stage.jfxAlert(configuration: JFXAlert<T>.() -> Unit): Optional<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXAlert<T>(this)
        .apply(configuration)
        .showAndWait()
}

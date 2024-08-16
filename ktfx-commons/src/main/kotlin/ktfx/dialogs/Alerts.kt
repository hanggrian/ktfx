@file:OptIn(ExperimentalContracts::class)

package ktfx.dialogs

import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.control.ButtonType
import javafx.scene.control.ButtonType.CLOSE
import javafx.scene.control.ButtonType.NO
import javafx.scene.control.ButtonType.YES
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Show an alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param configuration custom dialog action.
 * @return selected alert button.
 */
public inline fun alert(
    content: String = "",
    vararg buttonTypes: ButtonType = arrayOf(CLOSE),
    configuration: Alert.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Alert(AlertType.NONE, content, *buttonTypes)
        .apply(configuration)
        .showAndWait()
}

/**
 * Show an information alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param configuration custom dialog action.
 * @return selected alert button.
 */
public inline fun infoAlert(
    content: String = "",
    vararg buttonTypes: ButtonType = arrayOf(CLOSE),
    configuration: Alert.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Alert(AlertType.INFORMATION, content, *buttonTypes)
        .apply(configuration)
        .showAndWait()
}

/**
 * Show a warning alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param configuration custom dialog action.
 * @return selected alert button.
 */
public inline fun warningAlert(
    content: String = "",
    vararg buttonTypes: ButtonType = arrayOf(CLOSE),
    configuration: Alert.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Alert(AlertType.WARNING, content, *buttonTypes)
        .apply(configuration)
        .showAndWait()
}

/**
 * Show a confirmation alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param configuration custom dialog action.
 * @return selected alert button.
 */
public inline fun confirmAlert(
    content: String = "",
    vararg buttonTypes: ButtonType = arrayOf(YES, NO),
    configuration: Alert.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Alert(AlertType.CONFIRMATION, content, *buttonTypes)
        .apply(configuration)
        .showAndWait()
}

/**
 * Show an error alert.
 *
 * @param content alert message.
 * @param buttonTypes alert buttons.
 * @param configuration custom dialog action.
 * @return selected alert button.
 */
public inline fun errorAlert(
    content: String = "",
    vararg buttonTypes: ButtonType = arrayOf(CLOSE),
    configuration: Alert.() -> Unit,
): Optional<ButtonType> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Alert(AlertType.ERROR, content, *buttonTypes)
        .apply(configuration)
        .showAndWait()
}

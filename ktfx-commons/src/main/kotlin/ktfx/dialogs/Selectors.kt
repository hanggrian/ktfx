@file:OptIn(ExperimentalContracts::class)

package ktfx.dialogs

import javafx.scene.control.ChoiceDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param configuration custom dialog action.
 * @return selected item.
 */
public inline fun <T> selector(
    items: Collection<T>? = null,
    prefill: T? = null,
    configuration: ChoiceDialog<T>.() -> Unit,
): Optional<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ChoiceDialog<T>(prefill, items)
        .apply(configuration)
        .showAndWait()
}

/**
 * Show a selector.
 *
 * @param items selection choices.
 * @param prefill default choice.
 * @param configuration custom dialog action.
 * @return selected item.
 */
public inline fun <T> selector(
    vararg items: T,
    prefill: T? = null,
    configuration: ChoiceDialog<T>.() -> Unit,
): Optional<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ChoiceDialog<T>(prefill, *items)
        .apply(configuration)
        .showAndWait()
}

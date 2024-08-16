@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.dialogs

import javafx.scene.text.Font
import org.controlsfx.dialog.FontSelectorDialog
import java.util.Optional
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Build a font selector dialog with Kotlin DSL.
 *
 * @param defaultFont initially selected font.
 * @param configuration custom dialog action.
 * @return selected font.
 */
public inline fun fontSelector(
    defaultFont: Font? = null,
    configuration: FontSelectorDialog.() -> Unit,
): Optional<Font> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return FontSelectorDialog(defaultFont)
        .apply(configuration)
        .showAndWait()
}

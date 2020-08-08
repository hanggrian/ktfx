@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SplitMenuButton
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SplitMenuButton] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.splitMenuButton(): SplitMenuButton = splitMenuButton() { }

/**
 * Create a [SplitMenuButton] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun splitMenuButton(configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit):
    SplitMenuButton {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(KtfxSplitMenuButton(), configuration = configuration)
    }

/**
 * Add a [SplitMenuButton] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.splitMenuButton(
    configuration: (@LayoutDslMarker KtfxSplitMenuButton).() ->
    Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxSplitMenuButton(), configuration = configuration))
}

/**
 * Create a styled [SplitMenuButton].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledSplitMenuButton(vararg styleClass: String, id: String? = null): SplitMenuButton =
    styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SplitMenuButton] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledSplitMenuButton(vararg styleClass: String, id: String? = null):
    SplitMenuButton = styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SplitMenuButton] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxSplitMenuButton(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [SplitMenuButton] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxSplitMenuButton(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

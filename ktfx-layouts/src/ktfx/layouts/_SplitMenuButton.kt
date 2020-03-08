@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SplitMenuButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [SplitMenuButton] to this manager.
 */
fun NodeManager.splitMenuButton(): SplitMenuButton = splitMenuButton() { }

/**
 * Create a [SplitMenuButton] with configuration block.
 */
inline fun splitMenuButton(configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit):
        SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxSplitMenuButton(), configuration = configuration)
}

/**
 * Add a [SplitMenuButton] with configuration block to this manager.
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
 */
fun styledSplitMenuButton(vararg styleClass: String, id: String? = null): SplitMenuButton =
        styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SplitMenuButton] to this manager.
 */
fun NodeManager.styledSplitMenuButton(vararg styleClass: String, id: String? = null):
        SplitMenuButton = styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SplitMenuButton] with configuration block.
 */
inline fun styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxSplitMenuButton(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [SplitMenuButton] with configuration block to this manager.
 */
inline fun NodeManager.styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitMenuButton).() -> Unit
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxSplitMenuButton(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

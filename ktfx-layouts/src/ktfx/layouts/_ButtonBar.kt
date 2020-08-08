@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ButtonBar
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ButtonBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.buttonBar(buttonOrder: String? = null): ButtonBar = buttonBar(
    buttonOrder =
        buttonOrder
) { }

/**
 * Create a [ButtonBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun buttonBar(
    buttonOrder: String? = null,
    configuration: (
        @LayoutDslMarker    
        KtfxButtonBar
    ).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxButtonBar(buttonOrder), configuration = configuration)
}

/**
 * Add a [ButtonBar] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    configuration: (
        @LayoutDslMarker    
        KtfxButtonBar
    ).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxButtonBar(buttonOrder), configuration = configuration))
}

/**
 * Create a styled [ButtonBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null
): ButtonBar = styledButtonBar(buttonOrder = buttonOrder, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ButtonBar] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null
): ButtonBar = styledButtonBar(buttonOrder = buttonOrder, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ButtonBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxButtonBar(buttonOrder), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ButtonBar] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxButtonBar(buttonOrder), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

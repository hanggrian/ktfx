@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ButtonBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [ButtonBar].
 */
fun styledButtonBar(buttonOrder: String? = null, vararg styleClass: String): ButtonBar =
        styledButtonBar(buttonOrder = buttonOrder, styleClass = *styleClass) { }

/**
 * Add a styled [ButtonBar] to this manager.
 */
fun NodeManager.styledButtonBar(buttonOrder: String? = null, vararg styleClass: String): ButtonBar =
        styledButtonBar(buttonOrder = buttonOrder, styleClass = *styleClass) { }

/**
 * Create a styled [ButtonBar] with configuration block.
 */
inline fun styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxButtonBar(buttonOrder), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [ButtonBar] with configuration block to this manager.
 */
inline fun NodeManager.styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxButtonBar(buttonOrder), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [ButtonBar] to this manager.
 */
fun NodeManager.buttonBar(buttonOrder: String? = null): ButtonBar = buttonBar(buttonOrder =
        buttonOrder) { }

/**
 * Create a [ButtonBar] with configuration block.
 */
inline fun buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutDslMarker    
            KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxButtonBar(buttonOrder), configuration = configuration)
}

/**
 * Add a [ButtonBar] with configuration block to this manager.
 */
inline fun NodeManager.buttonBar(
    buttonOrder: String? = null,
    configuration: (@LayoutDslMarker    
            KtfxButtonBar).() -> Unit
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxButtonBar(buttonOrder), configuration = configuration))
}

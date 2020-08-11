@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.StatusBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [StatusBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.statusBar(): StatusBar = statusBar() { }

/**
 * Create a [StatusBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun statusBar(configuration: (@LayoutDslMarker StatusBar).() -> Unit): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(StatusBar(), configuration = configuration)
}

/**
 * Add a [StatusBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.statusBar(configuration: (@LayoutDslMarker StatusBar).() -> Unit):
    StatusBar {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(StatusBar(), configuration = configuration))
    }

/**
 * Create a styled [StatusBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledStatusBar(vararg styleClass: String, id: String? = null): StatusBar =
    styledStatusBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [StatusBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledStatusBar(vararg styleClass: String, id: String? = null): StatusBar =
    styledStatusBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [StatusBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledStatusBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(StatusBar(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [StatusBar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledStatusBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            StatusBar(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

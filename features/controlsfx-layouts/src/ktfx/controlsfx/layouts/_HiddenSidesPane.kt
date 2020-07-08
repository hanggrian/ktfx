@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HiddenSidesPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [HiddenSidesPane] to this manager.
 */
fun NodeManager.hiddenSidesPane(): HiddenSidesPane = hiddenSidesPane() { }

/**
 * Create a [HiddenSidesPane] with configuration block.
 */
inline fun hiddenSidesPane(configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit):
    HiddenSidesPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(KtfxHiddenSidesPane(), configuration = configuration)
    }

/**
 * Add a [HiddenSidesPane] with configuration block to this manager.
 */
inline fun NodeManager.hiddenSidesPane(
    configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() ->
    Unit
): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxHiddenSidesPane(), configuration = configuration))
}

/**
 * Create a styled [HiddenSidesPane].
 */
fun styledHiddenSidesPane(vararg styleClass: String, id: String? = null): HiddenSidesPane =
    styledHiddenSidesPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HiddenSidesPane] to this manager.
 */
fun NodeManager.styledHiddenSidesPane(vararg styleClass: String, id: String? = null):
    HiddenSidesPane = styledHiddenSidesPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HiddenSidesPane] with configuration block.
 */
inline fun styledHiddenSidesPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxHiddenSidesPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [HiddenSidesPane] with configuration block to this manager.
 */
inline fun NodeManager.styledHiddenSidesPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHiddenSidesPane).() -> Unit
): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxHiddenSidesPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

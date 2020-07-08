@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MaskerPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MaskerPane] to this manager.
 */
fun NodeManager.maskerPane(): MaskerPane = maskerPane() { }

/**
 * Create a [MaskerPane] with configuration block.
 */
inline fun maskerPane(configuration: (@LayoutDslMarker MaskerPane).() -> Unit): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MaskerPane(), configuration = configuration)
}

/**
 * Add a [MaskerPane] with configuration block to this manager.
 */
inline fun NodeManager.maskerPane(configuration: (@LayoutDslMarker MaskerPane).() -> Unit):
    MaskerPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(MaskerPane(), configuration = configuration))
    }

/**
 * Create a styled [MaskerPane].
 */
fun styledMaskerPane(vararg styleClass: String, id: String? = null): MaskerPane =
    styledMaskerPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MaskerPane] to this manager.
 */
fun NodeManager.styledMaskerPane(vararg styleClass: String, id: String? = null): MaskerPane =
    styledMaskerPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MaskerPane] with configuration block.
 */
inline fun styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MaskerPane(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [MaskerPane] with configuration block to this manager.
 */
inline fun NodeManager.styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            MaskerPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

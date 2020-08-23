@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.layouts.KtfxLayoutDslMarker
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
 *
 * @return the control added.
 */
fun NodeManager.maskerPane(): MaskerPane = maskerPane() { }

/**
 * Create a [MaskerPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun maskerPane(configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.configuration()
    return child
}

/**
 * Add a [MaskerPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.maskerPane(configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit):
    MaskerPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = MaskerPane()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [MaskerPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledMaskerPane(vararg styleClass: String, id: String? = null): MaskerPane =
    styledMaskerPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MaskerPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledMaskerPane(vararg styleClass: String, id: String? = null): MaskerPane =
    styledMaskerPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MaskerPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MaskerPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

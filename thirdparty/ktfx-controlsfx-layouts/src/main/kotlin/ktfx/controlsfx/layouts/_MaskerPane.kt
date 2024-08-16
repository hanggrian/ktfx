@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.MaskerPane

/**
 * Add a [MaskerPane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.maskerPane(): MaskerPane = maskerPane() { }

/**
 * Create a [MaskerPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun maskerPane(configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit):
        MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.configuration()
    return child
}

/**
 * Add a [MaskerPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.maskerPane(configuration: (@KtfxLayoutDslMarker
        MaskerPane).() -> Unit): MaskerPane {
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
public inline fun styledMaskerPane(vararg styleClass: String, id: String? = null): MaskerPane =
        styledMaskerPane(styleClass = styleClass, id = id) { }

/**
 * Add a styled [MaskerPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMaskerPane(vararg styleClass: String, id: String? = null):
        MaskerPane = styledMaskerPane(styleClass = styleClass, id = id) { }

/**
 * Create a styled [MaskerPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit,
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MaskerPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMaskerPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MaskerPane).() -> Unit,
): MaskerPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MaskerPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

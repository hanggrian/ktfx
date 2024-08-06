@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

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
import org.controlsfx.control.HiddenSidesPane

/**
 * Add a [HiddenSidesPane] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.hiddenSidesPane(): HiddenSidesPane = hiddenSidesPane() { }

/**
 * Create a [HiddenSidesPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun hiddenSidesPane(configuration: (@KtfxLayoutDslMarker
        KtfxHiddenSidesPane).() -> Unit): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHiddenSidesPane()
    child.configuration()
    return child
}

/**
 * Add a [HiddenSidesPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.hiddenSidesPane(configuration: (@KtfxLayoutDslMarker
        KtfxHiddenSidesPane).() -> Unit): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHiddenSidesPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [HiddenSidesPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledHiddenSidesPane(vararg styleClass: String, id: String? = null): HiddenSidesPane =
        styledHiddenSidesPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HiddenSidesPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledHiddenSidesPane(vararg styleClass: String, id: String? = null):
        HiddenSidesPane = styledHiddenSidesPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HiddenSidesPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledHiddenSidesPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxHiddenSidesPane).() -> Unit,
): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHiddenSidesPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [HiddenSidesPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledHiddenSidesPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxHiddenSidesPane).() -> Unit,
): HiddenSidesPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHiddenSidesPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

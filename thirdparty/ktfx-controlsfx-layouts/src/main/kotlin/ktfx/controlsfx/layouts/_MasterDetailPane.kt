@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.geometry.Side.RIGHT
import kotlin.Boolean
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
import org.controlsfx.control.MasterDetailPane

/**
 * Add a [MasterDetailPane] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.masterDetailPane(detailSide: Side = RIGHT, showDetailNode: Boolean = true):
        MasterDetailPane = masterDetailPane(detailSide = detailSide, showDetailNode =
        showDetailNode) { }

/**
 * Create a [MasterDetailPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun masterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    configuration: (@KtfxLayoutDslMarker KtfxMasterDetailPane).() -> Unit,
): MasterDetailPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMasterDetailPane(detailSide, showDetailNode)
    child.configuration()
    return child
}

/**
 * Add a [MasterDetailPane] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.masterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    configuration: (@KtfxLayoutDslMarker KtfxMasterDetailPane).() -> Unit,
): MasterDetailPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMasterDetailPane(detailSide, showDetailNode)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [MasterDetailPane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledMasterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): MasterDetailPane = styledMasterDetailPane(detailSide = detailSide, showDetailNode =
        showDetailNode, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MasterDetailPane] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledMasterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): MasterDetailPane = styledMasterDetailPane(detailSide = detailSide, showDetailNode =
        showDetailNode, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MasterDetailPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledMasterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMasterDetailPane).() -> Unit,
): MasterDetailPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMasterDetailPane(detailSide, showDetailNode)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MasterDetailPane] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMasterDetailPane(
    detailSide: Side = RIGHT,
    showDetailNode: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMasterDetailPane).() -> Unit,
): MasterDetailPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMasterDetailPane(detailSide, showDetailNode)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
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

/**
 * Add a [JFXDefaultChip] to this container.
 *
 * @return the control added.
 */
public fun <T> NodeContainer.jfxDefaultChip(view: JFXChipView<T>, item: T): JFXDefaultChip<T> =
        jfxDefaultChip(view = view, item = item) { }

/**
 * Create a [JFXDefaultChip] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@KtfxLayoutDslMarker JFXDefaultChip<T>).() -> Unit,
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDefaultChip<T>(view, item)
    child.configuration()
    return child
}

/**
 * Add a [JFXDefaultChip] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@KtfxLayoutDslMarker JFXDefaultChip<T>).() -> Unit,
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDefaultChip<T>(view, item)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXDefaultChip].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <T> styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
): JFXDefaultChip<T> = styledJFXDefaultChip(view = view, item = item, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [JFXDefaultChip] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <T> NodeContainer.styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
): JFXDefaultChip<T> = styledJFXDefaultChip(view = view, item = item, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [JFXDefaultChip] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDefaultChip<T>).() -> Unit,
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDefaultChip<T>(view, item)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDefaultChip] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDefaultChip<T>).() -> Unit,
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDefaultChip<T>(view, item)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

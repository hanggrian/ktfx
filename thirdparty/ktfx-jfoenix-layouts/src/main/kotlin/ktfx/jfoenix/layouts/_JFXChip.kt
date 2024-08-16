@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
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
 * Add a [JFXChip] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxChip(view: JFXChipView<T>, item: T): JFXChip<T> =
        jfxChip(view = view, item = item) { }

/**
 * Create a [JFXChip] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@KtfxLayoutDslMarker JFXChip<T>).() -> Unit,
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChip<T>(view, item)
    child.configuration()
    return child
}

/**
 * Add a [JFXChip] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@KtfxLayoutDslMarker JFXChip<T>).() -> Unit,
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChip<T>(view, item)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXChip].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJfxChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
): JFXChip<T> = styledJfxChip(view = view, item = item, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXChip] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJfxChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
): JFXChip<T> = styledJfxChip(view = view, item = item, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXChip] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <T> styledJfxChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChip<T>).() -> Unit,
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChip<T>(view, item)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXChip] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJfxChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChip<T>).() -> Unit,
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChip<T>(view, item)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

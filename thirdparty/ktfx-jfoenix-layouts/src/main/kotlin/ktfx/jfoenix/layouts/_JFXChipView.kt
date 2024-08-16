@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.jfoenix.layouts

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
 * Add a [JFXChipView] to this container.
 *
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxChipView(): JFXChipView<T> = jfxChipView() { }

/**
 * Create a [JFXChipView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun <T> jfxChipView(configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit):
        JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.configuration()
    return child
}

/**
 * Add a [JFXChipView] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun <T> NodeContainer.jfxChipView(configuration: (@KtfxLayoutDslMarker
        JFXChipView<T>).() -> Unit): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXChipView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun <T> styledJfxChipView(vararg styleClass: String, id: String? = null):
        JFXChipView<T> = styledJfxChipView(styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXChipView] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJfxChipView(vararg styleClass: String, id: String? =
        null): JFXChipView<T> = styledJfxChipView(styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXChipView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun <T> styledJfxChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit,
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXChipView] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun <T> NodeContainer.styledJfxChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit,
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

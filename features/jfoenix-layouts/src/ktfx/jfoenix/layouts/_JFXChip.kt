@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChip
import com.jfoenix.controls.JFXChipView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXChip] to this manager.
 */
fun <T> NodeManager.jfxChip(view: JFXChipView<T>, item: T): JFXChip<T> = jfxChip(view = view, item =
        item) { }

/**
 * Create a [JFXChip] with configuration block.
 */
inline fun <T> jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXChip<T>(view, item), configuration = configuration)
}

/**
 * Add a [JFXChip] with configuration block to this manager.
 */
inline fun <T> NodeManager.jfxChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXChip<T>(view, item), configuration = configuration))
}

/**
 * Create a styled [JFXChip].
 */
fun <T> styledJFXChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null
): JFXChip<T> = styledJFXChip(view = view, item = item, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXChip] to this manager.
 */
fun <T> NodeManager.styledJFXChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null
): JFXChip<T> = styledJFXChip(view = view, item = item, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXChip] with configuration block.
 */
inline fun <T> styledJFXChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXChip<T>(view, item), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXChip] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledJFXChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXChip<T>).() -> Unit
): JFXChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXChip<T>(view, item), styleClass = *styleClass, id = id,
            configuration = configuration))
}

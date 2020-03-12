@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import com.jfoenix.controls.JFXDefaultChip
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
 * Add a [JFXDefaultChip] to this manager.
 */
fun <T> NodeManager.jfxDefaultChip(view: JFXChipView<T>, item: T): JFXDefaultChip<T> =
        jfxDefaultChip(view = view, item = item) { }

/**
 * Create a [JFXDefaultChip] with configuration block.
 */
inline fun <T> jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXDefaultChip<T>(view, item), configuration = configuration)
}

/**
 * Add a [JFXDefaultChip] with configuration block to this manager.
 */
inline fun <T> NodeManager.jfxDefaultChip(
    view: JFXChipView<T>,
    item: T,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXDefaultChip<T>(view, item), configuration = configuration))
}

/**
 * Create a styled [JFXDefaultChip].
 */
fun <T> styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null
): JFXDefaultChip<T> = styledJFXDefaultChip(view = view, item = item, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [JFXDefaultChip] to this manager.
 */
fun <T> NodeManager.styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null
): JFXDefaultChip<T> = styledJFXDefaultChip(view = view, item = item, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [JFXDefaultChip] with configuration block.
 */
inline fun <T> styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXDefaultChip<T>(view, item), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXDefaultChip] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledJFXDefaultChip(
    view: JFXChipView<T>,
    item: T,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXDefaultChip<T>).() -> Unit
): JFXDefaultChip<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXDefaultChip<T>(view, item), styleClass = *styleClass, id = id,
            configuration = configuration))
}

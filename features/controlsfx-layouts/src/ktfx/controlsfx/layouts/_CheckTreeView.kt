@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.control.CheckBoxTreeItem
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.CheckTreeView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckTreeView] to this manager.
 */
fun <T> NodeManager.checkTreeView(root: CheckBoxTreeItem<T>? = null): CheckTreeView<T> =
    checkTreeView(root = root) { }

/**
 * Create a [CheckTreeView] with configuration block.
 */
inline fun <T> checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (
        @LayoutDslMarker    
        CheckTreeView<T>
    ).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckTreeView<T>(root), configuration = configuration)
}

/**
 * Add a [CheckTreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.checkTreeView(
    root: CheckBoxTreeItem<T>? = null,
    configuration: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckTreeView<T>(root), configuration = configuration))
}

/**
 * Create a styled [CheckTreeView].
 */
fun <T> styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): CheckTreeView<T> = styledCheckTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [CheckTreeView] to this manager.
 */
fun <T> NodeManager.styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null
): CheckTreeView<T> = styledCheckTreeView(root = root, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [CheckTreeView] with configuration block.
 */
inline fun <T> styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        CheckTreeView<T>(root), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [CheckTreeView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledCheckTreeView(
    root: CheckBoxTreeItem<T>? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckTreeView<T>).() -> Unit
): CheckTreeView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            CheckTreeView<T>(root), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MenuItem] to this manager.
 */
fun MenuItemManager.menuItem(text: String? = null, graphic: Node? = null): MenuItem = menuItem(text =
        text, graphic = graphic) { }

/**
 * Create a [MenuItem] with configuration block.
 */
inline fun menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [MenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.menuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [MenuItem].
 */
fun styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [MenuItem] to this manager.
 */
fun MenuItemManager.styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): MenuItem = styledMenuItem(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [MenuItem] with configuration block.
 */
inline fun styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MenuItem(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [MenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker MenuItem).() -> Unit
): MenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MenuItem(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Menu] to this manager.
 */
fun MenuItemManager.menu(text: String = "", graphic: Node? = null): Menu = menu(text = text, graphic =
        graphic) { }

/**
 * Add a [Menu] to this manager.
 */
fun MenuManager.menu(text: String = "", graphic: Node? = null): Menu = menu(text = text, graphic =
        graphic) { }

/**
 * Create a [Menu] with configuration block.
 */
inline fun menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenu(text, graphic), configuration = configuration)
}

/**
 * Add a [Menu] with configuration block to this manager.
 */
inline fun MenuItemManager.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenu(text, graphic), configuration = configuration))
}

/**
 * Add a [Menu] with configuration block to this manager.
 */
inline fun MenuManager.menu(
    text: String = "",
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenu(text, graphic), configuration = configuration))
}

/**
 * Create a styled [Menu].
 */
fun styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String
): Menu = styledMenu(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [Menu] to this manager.
 */
fun MenuItemManager.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String
): Menu = styledMenu(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [Menu] to this manager.
 */
fun MenuManager.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String
): Menu = styledMenu(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [Menu] with configuration block.
 */
inline fun styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenu(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [Menu] with configuration block to this manager.
 */
inline fun MenuItemManager.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenu(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a styled [Menu] with configuration block to this manager.
 */
inline fun MenuManager.styledMenu(
    text: String = "",
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxMenu).() -> Unit
): Menu {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenu(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

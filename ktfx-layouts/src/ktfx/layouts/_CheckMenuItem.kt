@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [CheckMenuItem] to this manager.
 */
fun MenuItemManager.checkMenuItem(text: String, graphic: Node): CheckMenuItem = checkMenuItem(text =
        text, graphic = graphic) { }

/**
 * Create a [CheckMenuItem] with configuration block.
 */
inline fun checkMenuItem(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckMenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [CheckMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.checkMenuItem(
    text: String,
    graphic: Node,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckMenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [CheckMenuItem].
 */
fun styledCheckMenuItem(
    text: String,
    graphic: Node,
    vararg styleClass: String
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [CheckMenuItem] to this manager.
 */
fun MenuItemManager.styledCheckMenuItem(
    text: String,
    graphic: Node,
    vararg styleClass: String
): CheckMenuItem = styledCheckMenuItem(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [CheckMenuItem] with configuration block.
 */
inline fun styledCheckMenuItem(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckMenuItem(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [CheckMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledCheckMenuItem(
    text: String,
    graphic: Node,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckMenuItem(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

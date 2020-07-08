@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [CheckMenuItem] to this manager.
 */
fun MenuItemManager.checkMenuItem(text: String? = null, graphic: Node? = null): CheckMenuItem =
    checkMenuItem(text = text, graphic = graphic) { }

/**
 * Create a [CheckMenuItem] with configuration block.
 */
inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(CheckMenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [CheckMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(CheckMenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [CheckMenuItem].
 */
fun styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): CheckMenuItem = styledCheckMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [CheckMenuItem] to this manager.
 */
fun MenuItemManager.styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): CheckMenuItem = styledCheckMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [CheckMenuItem] with configuration block.
 */
inline fun styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        CheckMenuItem(text, graphic), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [CheckMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledCheckMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker CheckMenuItem).() -> Unit
): CheckMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            CheckMenuItem(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

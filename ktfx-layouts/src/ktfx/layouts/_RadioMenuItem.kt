@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [RadioMenuItem] to this manager.
 */
fun MenuItemManager.radioMenuItem(text: String? = null, graphic: Node? = null): RadioMenuItem =
    radioMenuItem(text = text, graphic = graphic) { }

/**
 * Create a [RadioMenuItem] with configuration block.
 */
inline fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(RadioMenuItem(text, graphic), configuration = configuration)
}

/**
 * Add a [RadioMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(RadioMenuItem(text, graphic), configuration = configuration))
}

/**
 * Create a styled [RadioMenuItem].
 */
fun styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): RadioMenuItem = styledRadioMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [RadioMenuItem] to this manager.
 */
fun MenuItemManager.styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null
): RadioMenuItem = styledRadioMenuItem(
    text = text, graphic = graphic, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [RadioMenuItem] with configuration block.
 */
inline fun styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        RadioMenuItem(text, graphic), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [RadioMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledRadioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            RadioMenuItem(text, graphic), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MenuButton] to this manager.
 */
fun NodeManager.menuButton(text: String? = null, graphic: Node? = null): MenuButton =
        menuButton(text = text, graphic = graphic) { }

/**
 * Create a [MenuButton] with configuration block.
 */
inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenuButton(text, graphic), configuration = configuration)
}

/**
 * Add a [MenuButton] with configuration block to this manager.
 */
inline fun NodeManager.menuButton(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenuButton(text, graphic), configuration = configuration))
}

/**
 * Create a styled [MenuButton].
 */
fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Add a styled [MenuButton] to this manager.
 */
fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String
): MenuButton = styledMenuButton(text = text, graphic = graphic, styleClass = *styleClass) { }

/**
 * Create a styled [MenuButton] with configuration block.
 */
inline fun styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxMenuButton(text, graphic), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [MenuButton] with configuration block to this manager.
 */
inline fun NodeManager.styledMenuButton(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker KtfxMenuButton).() -> Unit
): MenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxMenuButton(text, graphic), styleClass = *styleClass, configuration =
            configuration))
}

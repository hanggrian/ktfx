@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioMenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [RadioMenuItem] with initialization block. */
inline fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return RadioMenuItem(text, graphic).apply(configuration)
}

/** Add a [RadioMenuItem] to this manager. */
fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null
): RadioMenuItem = addChild(RadioMenuItem(text, graphic))

/** Add a [RadioMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@LayoutsDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(RadioMenuItem(text, graphic), configuration)
}

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
    init: (@KtfxLayoutsDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return RadioMenuItem(text, graphic).apply(init)
}

/** Add a [RadioMenuItem] to this manager. */
fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null
): RadioMenuItem = addItem(RadioMenuItem(text, graphic))

/** Add a [RadioMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@KtfxLayoutsDslMarker RadioMenuItem).() -> Unit
): RadioMenuItem {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addItem(RadioMenuItem(text, graphic), init)
}

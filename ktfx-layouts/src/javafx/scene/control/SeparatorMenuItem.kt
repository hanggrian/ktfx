@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem

/** Create a [SeparatorMenuItem] with initialization block. */
inline fun separatorMenuItem(
    init: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem = SeparatorMenuItem().apply(init)

/** Add a [SeparatorMenuItem] to this manager. */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem =
    addItem(SeparatorMenuItem())

/** Add a [SeparatorMenuItem] with initialization block to this manager. */
inline fun MenuItemManager.separatorMenuItem(
    init: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem = addItem(SeparatorMenuItem(), init)

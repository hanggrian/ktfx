@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuButton

inline fun menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = menuButton(text, graphic) { }

inline fun menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl MenuButton).() -> Unit
): MenuButton = MenuButton(text, graphic).apply(init)

inline fun LayoutManager<Node>.menuButton(
    text: String? = null,
    graphic: Node? = null
): MenuButton = menuButton(text, graphic) { }

inline fun LayoutManager<Node>.menuButton(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl MenuButton).() -> Unit
): MenuButton = ktfx.layouts.menuButton(text, graphic, init).add()
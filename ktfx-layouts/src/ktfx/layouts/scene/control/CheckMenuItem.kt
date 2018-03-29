@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.MenuItem

inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = checkMenuItem(text, graphic) { }

inline fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl CheckMenuItem).() -> Unit
): CheckMenuItem = CheckMenuItem(text, graphic).apply(init)

inline fun LayoutManager<MenuItem>.checkMenuItem(
    text: String? = null,
    graphic: Node? = null
): CheckMenuItem = checkMenuItem(text, graphic) { }

inline fun LayoutManager<MenuItem>.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl CheckMenuItem).() -> Unit
): CheckMenuItem = ktfx.layouts.checkMenuItem(text, graphic, init).add()
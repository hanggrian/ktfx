@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem

inline fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null
): RadioMenuItem = radioMenuItem(text, graphic) { }

inline fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl RadioMenuItem).() -> Unit
): RadioMenuItem = RadioMenuItem(text, graphic).apply(init)

inline fun LayoutManager<MenuItem>.radioMenuItem(
    text: String? = null,
    graphic: Node? = null
): RadioMenuItem = radioMenuItem(text, graphic) { }

inline fun LayoutManager<MenuItem>.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl RadioMenuItem).() -> Unit
): RadioMenuItem = ktfx.layouts.radioMenuItem(text, graphic, init).add()
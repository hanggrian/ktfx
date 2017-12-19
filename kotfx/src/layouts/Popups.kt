@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.Node
import javafx.scene.control.*

inline fun contextMenu(vararg items: MenuItem, noinline init: (@KotfxDsl _ContextMenu).() -> Unit): ContextMenu = _ContextMenu(*items).apply(init)

@JvmOverloads inline fun checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.checkMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl CheckMenuItem).() -> Unit)? = null): CheckMenuItem = CheckMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.customMenuItem(node: Node? = null, hideOnClick: Boolean = true, noinline init: ((@KotfxDsl CustomMenuItem).() -> Unit)? = null): CustomMenuItem = CustomMenuItem(node, hideOnClick).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.menuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl MenuItem).() -> Unit)? = null): MenuItem = MenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.radioMenuItem(text: String? = null, graphic: Node? = null, noinline init: ((@KotfxDsl RadioMenuItem).() -> Unit)? = null): RadioMenuItem = RadioMenuItem(text, graphic).apply { init?.invoke(this) }.add()

@JvmOverloads inline fun separatorMenuItem(noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }
@JvmOverloads inline fun PopupManager.separatorMenuItem(noinline init: ((@KotfxDsl SeparatorMenuItem).() -> Unit)? = null): SeparatorMenuItem = SeparatorMenuItem().apply { init?.invoke(this) }.add()

@JvmOverloads inline fun tooltip(text: String? = null, noinline init: ((@KotfxDsl Tooltip).() -> Unit)? = null): Tooltip = Tooltip(text).apply { init?.invoke(this) }
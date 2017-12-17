@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl
import kotfx.internal.ItemManager

@JvmOverloads
inline fun tabPaneOf(
        vararg tabs: Tab,
        noinline init: ((@ControlDsl TabPane).() -> Unit)? = null
): TabPane = TabPane(*tabs).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.tabPane(
        vararg tabs: Tab,
        noinline init: ((@ControlDsl TabPane).() -> Unit)? = null
): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()

@JvmOverloads
inline fun ItemManager.tabPane(
        vararg tabs: Tab,
        noinline init: ((@ControlDsl TabPane).() -> Unit)? = null
): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()
@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import kotfx.ChildManager
import kotfx.internal.ControlDsl

@JvmOverloads
inline fun tabPane(
        vararg tabs: Tab,
        noinline init: ((@ControlDsl TabPane).() -> Unit)? = null
): TabPane = TabPane(*tabs).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.tabPane(
        vararg tabs: Tab,
        noinline init: ((@ControlDsl TabPane).() -> Unit)? = null
): TabPane = TabPane(*tabs).apply { init?.invoke(this) }.add()
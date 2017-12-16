@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.Node
import javafx.scene.control.TitledPane
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun titledPane(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, graphic).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.titledPane(
        text: String? = null,
        graphic: Node? = null,
        noinline init: ((@ControlDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, graphic).apply { init?.invoke(this) }.add()
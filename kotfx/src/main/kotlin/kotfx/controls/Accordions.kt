@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import kotfx.internal.ControlDsl
import kotfx.layouts.ChildManager

@JvmOverloads
inline fun accordion(
        vararg panes: TitledPane,
        noinline init: ((@ControlDsl Accordion).() -> Unit)? = null
): Accordion = Accordion(*panes).apply { init?.invoke(this) }

@JvmOverloads
inline fun ChildManager.accordion(
        vararg panes: TitledPane,
        noinline init: ((@ControlDsl Accordion).() -> Unit)? = null
): Accordion = Accordion(*panes).apply { init?.invoke(this) }.add()
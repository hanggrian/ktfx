@file:JvmMultifileClass
@file:JvmName("ControlsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.controls

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import kotfx.internal.ChildManager
import kotfx.internal.ControlDsl

class _Accordion(vararg panes: TitledPane) : Accordion(*panes), _Control<Accordion> {
    override val control: Accordion get() = this
    fun expand(pane: TitledPane) = setExpandedPane(pane)
}

@JvmOverloads
inline fun accordion(
        vararg panes: TitledPane,
        noinline init: ((@ControlDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion(*panes).apply { if (init != null) init() }

@JvmOverloads
inline fun ChildManager.accordion(
        vararg panes: TitledPane,
        noinline init: ((@ControlDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion(*panes).apply { if (init != null) init() }.add()
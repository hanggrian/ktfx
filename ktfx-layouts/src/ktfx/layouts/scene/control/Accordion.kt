@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

inline fun accordion(
    vararg titledPanes: TitledPane,
    noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null
): Accordion = Accordion(*titledPanes).apply { init?.invoke(this) }

inline fun Manager<Node>.accordion(
    vararg titledPanes: TitledPane,
    noinline init: ((@LayoutDsl Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()
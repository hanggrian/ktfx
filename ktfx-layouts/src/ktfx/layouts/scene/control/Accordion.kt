@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

inline fun accordion(
    vararg titledPanes: TitledPane
): Accordion = accordion(*titledPanes) { }

inline fun accordion(
    vararg titledPanes: TitledPane,
    init: (@LayoutDsl Accordion).() -> Unit
): Accordion = Accordion(*titledPanes).apply(init)

inline fun LayoutManager<Node>.accordion(
    vararg titledPanes: TitledPane
): Accordion = accordion(*titledPanes) { }

inline fun LayoutManager<Node>.accordion(
    vararg titledPanes: TitledPane,
    init: (@LayoutDsl Accordion).() -> Unit
): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()
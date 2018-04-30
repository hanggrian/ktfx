@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

class _Accordion(
    vararg titledPanes: TitledPane
) : Accordion(*titledPanes), LayoutManager<TitledPane> {

    override val childs: ObservableList<TitledPane> get() = panes

    /** Convenient method to add button to this bar by only using string. */
    inline operator fun String.invoke(content: Node? = null): TitledPane = invoke(content) { }

    /** Convenient method to add button to this bar by only using string. */
    inline operator fun String.invoke(
        content: Node? = null,
        init: (@LayoutDsl _TitledPane).() -> Unit
    ): TitledPane = titledPane(this, content, init).add()
}

inline fun accordion(
    vararg titledPanes: TitledPane
): Accordion = accordion(*titledPanes) { }

inline fun accordion(
    vararg titledPanes: TitledPane,
    init: (@LayoutDsl _Accordion).() -> Unit
): Accordion = _Accordion(*titledPanes).apply(init)

inline fun LayoutManager<Node>.accordion(
    vararg titledPanes: TitledPane
): Accordion = accordion(*titledPanes) { }

inline fun LayoutManager<Node>.accordion(
    vararg titledPanes: TitledPane,
    init: (@LayoutDsl _Accordion).() -> Unit
): Accordion = ktfx.layouts.accordion(*titledPanes, init = init).add()
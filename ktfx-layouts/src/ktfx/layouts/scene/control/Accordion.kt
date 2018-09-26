@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

class _Accordion(
    vararg titledPanes: TitledPane
) : Accordion(*titledPanes), LayoutManager<TitledPane> {

    override val childs: MutableCollection<TitledPane> get() = panes

    /** Creates a [TitledPane] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        content: Node? = null,
        noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
    ): TitledPane = titledPane(this, content, init)()

    /** Creates a styled [TitledPane] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        content: Node? = null,
        noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
    ): TitledPane = styledTitledPane(styleClass, this, content, init)()
}

/** Creates a [Accordion]. */
fun accordion(
    vararg titledPanes: TitledPane,
    init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion(*titledPanes).also {
    init?.invoke(it)
}

/** Creates a [Accordion] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.accordion(
    vararg titledPanes: TitledPane,
    noinline init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.accordion(*titledPanes, init = init)()

/** Create a styled [Accordion]. */
fun styledAccordion(
    styleClass: String,
    vararg titledPanes: TitledPane,
    init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion(*titledPanes).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Accordion] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledAccordion(
    styleClass: String,
    vararg titledPanes: TitledPane,
    noinline init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.styledAccordion(styleClass, *titledPanes, init = init)()
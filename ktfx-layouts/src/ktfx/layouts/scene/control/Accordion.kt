@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

open class _Accordion : Accordion(), TitledPaneManager {

    override fun <T : TitledPane> addPane(pane: T): T = pane.also { panes += it }

    /** Call [NodeManager.titledPane] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker _TitledPane).() -> Unit
    ): TitledPane = titledPane(this, init)
}

/** Create an [Accordion] with initialization block. */
inline fun accordion(
    init: (@LayoutDslMarker _Accordion).() -> Unit
): Accordion = _Accordion().apply(init)

/** Add an [Accordion] to this manager. */
fun NodeManager.accordion(): Accordion =
    addNode(ktfx.layouts.accordion { })

/** Add an [Accordion] with initialization block to this manager. */
inline fun NodeManager.accordion(
    init: (@LayoutDslMarker _Accordion).() -> Unit
): Accordion = addNode(ktfx.layouts.accordion(init))

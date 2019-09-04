@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

open class _Accordion : Accordion(), TitledPaneManager {

    override fun <R : TitledPane> R.add(): R = also { panes += it }

    /** Call [NodeManager.accordion] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker _TitledPane).() -> Unit
    ): TitledPane = titledPane(this, init)
}

/** Creates a [Accordion]. */
fun accordion(): Accordion = _Accordion()

/** Creates a [Accordion] with initialization block. */
inline fun accordion(
    init: (@LayoutDslMarker _Accordion).() -> Unit
): Accordion = (accordion() as _Accordion).apply(init)

/** Creates and add a [Accordion] to this manager. */
fun NodeManager.accordion(): Accordion = ktfx.layouts.accordion().add()

/** Creates and add a [Accordion] with initialization block to this manager. */
inline fun NodeManager.accordion(
    init: (@LayoutDslMarker _Accordion).() -> Unit
): Accordion = ktfx.layouts.accordion(init).add()

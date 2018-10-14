@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import ktfx.NodeManager
import ktfx.TitledPaneManager
import ktfx.annotations.LayoutDsl

open class _Accordion(vararg titledPanes: TitledPane) : Accordion(*titledPanes), TitledPaneManager {

    /** Creates a [TitledPane] and add it to this manager. */
    inline operator fun String.invoke(
        content: Node? = null,
        noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
    ): TitledPane = titledPane(this, content, init)()
}

/** Creates a [Accordion]. */
fun accordion(
    vararg titledPanes: TitledPane,
    init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion(*titledPanes).also { init?.invoke(it) }

/** Creates a [Accordion] and add it to this manager. */
inline fun NodeManager.accordion(
    vararg titledPanes: TitledPane,
    noinline init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.accordion(*titledPanes, init = init)()
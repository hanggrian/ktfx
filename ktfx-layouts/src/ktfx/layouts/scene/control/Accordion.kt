@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

open class _Accordion : Accordion(), TitledPaneManager {

    override fun <R : TitledPane> R.add(): R = also { panes += it }

    /** Creates a [TitledPane] and add it to this manager. */
    inline operator fun String.invoke(
        noinline init: ((@LayoutDslMarker _TitledPane).() -> Unit)? = null
    ): TitledPane = titledPane(this, init)
}

/** Creates a [Accordion]. */
fun accordion(
    init: ((@LayoutDslMarker _Accordion).() -> Unit)? = null
): Accordion = _Accordion().also { init?.invoke(it) }

/** Creates a [Accordion] and add it to this manager. */
inline fun NodeManager.accordion(
    noinline init: ((@LayoutDslMarker _Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.accordion(init).add()
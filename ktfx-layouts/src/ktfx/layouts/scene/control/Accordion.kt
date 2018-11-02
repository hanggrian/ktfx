@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import ktfx.LayoutDsl
import ktfx.NodeInvokable
import ktfx.TitledPaneInvokable

open class _Accordion : Accordion(), TitledPaneInvokable {

    override fun <R : TitledPane> R.invoke(): R = also { panes += it }

    /** Creates a [TitledPane] and add it to this manager. */
    inline operator fun String.invoke(
        noinline init: ((@LayoutDsl _TitledPane).() -> Unit)? = null
    ): TitledPane = titledPane(this, init)
}

/** Creates a [Accordion]. */
fun accordion(
    init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = _Accordion().also { init?.invoke(it) }

/** Creates a [Accordion] and add it to this manager. */
inline fun NodeInvokable.accordion(
    noinline init: ((@LayoutDsl _Accordion).() -> Unit)? = null
): Accordion = ktfx.layouts.accordion(init)()
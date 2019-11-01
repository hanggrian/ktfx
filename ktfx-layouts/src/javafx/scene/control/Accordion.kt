@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane

open class KtfxAccordion : Accordion(), TitledPaneManager {

    final override fun <T : TitledPane> addPane(pane: T): T =
        pane.also { panes += it }

    /** Call [NodeManager.titledPane] by string invocation. */
    inline operator fun String.invoke(
        init: (@LayoutDslMarker KtfxTitledPane).() -> Unit
    ): TitledPane = titledPane(this, init)
}

/** Create an [Accordion] with initialization block. */
inline fun accordion(init: (@LayoutDslMarker KtfxAccordion).() -> Unit): Accordion =
    KtfxAccordion().apply(init)

/** Add an [Accordion] to this manager. */
fun NodeManager.accordion(): Accordion =
    addNode(KtfxAccordion())

/** Add an [Accordion] with initialization block to this manager. */
inline fun NodeManager.accordion(init: (@LayoutDslMarker KtfxAccordion).() -> Unit): Accordion =
    addNode(KtfxAccordion(), init)

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Accordion
import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * [Accordion] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxAccordion : Accordion(), TitledPaneManager {

    final override fun <T : TitledPane> addPane(pane: T): T = pane.also { panes += it }

    /** Call [NodeManager.titledPane] by string invocation. */
    inline operator fun String.invoke(
        init: (@KtfxLayoutsDslMarker KtfxTitledPane).() -> Unit
    ): TitledPane = titledPane(this, init)
}

/** Create an [Accordion] with initialization block. */
inline fun accordion(
    init: (@KtfxLayoutsDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxAccordion().apply(init)
}

/** Add an [Accordion] to this manager. */
fun NodeManager.accordion(): Accordion =
    addNode(KtfxAccordion())

/** Add an [Accordion] with initialization block to this manager. */
inline fun NodeManager.accordion(
    init: (@KtfxLayoutsDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxAccordion(), init)
}

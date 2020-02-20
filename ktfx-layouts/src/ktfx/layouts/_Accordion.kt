@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Accordion
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [Accordion].
 */
fun styledAccordion(vararg styleClass: String): Accordion = styledAccordion(*styleClass) { }

/**
 * Add a styled [Accordion] to this manager.
 */
fun NodeManager.styledAccordion(vararg styleClass: String): Accordion = styledAccordion(*styleClass) { }

/**
 * Create a styled [Accordion] with configuration block.
 */
inline fun styledAccordion(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker
            KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return newChild(KtfxAccordion(), *styleClass, configuration = configuration)
}

/**
 * Add a styled [Accordion] with configuration block to this manager.
 */
inline fun NodeManager.styledAccordion(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker
            KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(newChild(KtfxAccordion(), *styleClass, configuration = configuration))
}

/**
 * Add an [Accordion] to this manager.
 */
fun NodeManager.accordion(): Accordion = accordion { }

/**
 * Create an [Accordion] with configuration block.
 */
inline fun accordion(configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit): Accordion {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return newChild(KtfxAccordion(), configuration = configuration)
}

/**
 * Add an [Accordion] with configuration block to this manager.
 */
inline fun NodeManager.accordion(configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit):
        Accordion {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(newChild(KtfxAccordion(), configuration = configuration))
}

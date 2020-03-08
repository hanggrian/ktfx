@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Accordion
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add an [Accordion] to this manager.
 */
fun NodeManager.accordion(): Accordion = accordion() { }

/**
 * Create an [Accordion] with configuration block.
 */
inline fun accordion(configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxAccordion(), configuration = configuration)
}

/**
 * Add an [Accordion] with configuration block to this manager.
 */
inline fun NodeManager.accordion(configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit):
        Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxAccordion(), configuration = configuration))
}

/**
 * Create a styled [Accordion].
 */
fun styledAccordion(vararg styleClass: String, id: String? = null): Accordion =
        styledAccordion(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Accordion] to this manager.
 */
fun NodeManager.styledAccordion(vararg styleClass: String, id: String? = null): Accordion =
        styledAccordion(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Accordion] with configuration block.
 */
inline fun styledAccordion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxAccordion(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [Accordion] with configuration block to this manager.
 */
inline fun NodeManager.styledAccordion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxAccordion(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
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

/**
 * Add an [Accordion] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.accordion(): Accordion = accordion() { }

/**
 * Create an [Accordion] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun accordion(configuration: (@KtfxLayoutDslMarker KtfxAccordion).() -> Unit):
    Accordion {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxAccordion()
        child.configuration()
        return child
    }

/**
 * Add an [Accordion] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.accordion(
    configuration: (@KtfxLayoutDslMarker KtfxAccordion).() ->
    Unit
): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAccordion()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Accordion].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledAccordion(vararg styleClass: String, id: String? = null): Accordion =
    styledAccordion(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Accordion] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledAccordion(vararg styleClass: String, id: String? = null): Accordion =
    styledAccordion(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Accordion] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledAccordion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAccordion()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Accordion] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledAccordion(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxAccordion).() -> Unit
): Accordion {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAccordion()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

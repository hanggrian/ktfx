@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.text.TextFlow
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TextFlow] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.textFlow(): TextFlow = textFlow() { }

/**
 * Create a [TextFlow] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun textFlow(configuration: (@KtfxLayoutDslMarker KtfxTextFlow).() -> Unit):
        TextFlow {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTextFlow()
    child.configuration()
    return child
}

/**
 * Add a [TextFlow] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.textFlow(configuration: (@KtfxLayoutDslMarker
        KtfxTextFlow).() -> Unit): TextFlow {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTextFlow()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TextFlow].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledTextFlow(vararg styleClass: String, id: String? = null): TextFlow =
        styledTextFlow(styleClass = styleClass, id = id) { }

/**
 * Add a styled [TextFlow] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledTextFlow(vararg styleClass: String, id: String? = null):
        TextFlow = styledTextFlow(styleClass = styleClass, id = id) { }

/**
 * Create a styled [TextFlow] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledTextFlow(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTextFlow).() -> Unit,
): TextFlow {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTextFlow()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TextFlow] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledTextFlow(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTextFlow).() -> Unit,
): TextFlow {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTextFlow()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

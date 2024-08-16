@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.ButtonBar
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ButtonBar] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.buttonBar(buttonOrder: String? = null): ButtonBar =
        buttonBar(buttonOrder = buttonOrder) { }

/**
 * Create a [ButtonBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun buttonBar(buttonOrder: String? = null, configuration: (@KtfxLayoutDslMarker
        KtfxButtonBar).() -> Unit): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxButtonBar(buttonOrder)
    child.configuration()
    return child
}

/**
 * Add a [ButtonBar] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.buttonBar(buttonOrder: String? = null,
        configuration: (@KtfxLayoutDslMarker KtfxButtonBar).() -> Unit): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxButtonBar(buttonOrder)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ButtonBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
): ButtonBar = styledButtonBar(buttonOrder = buttonOrder, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ButtonBar] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
): ButtonBar = styledButtonBar(buttonOrder = buttonOrder, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ButtonBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxButtonBar).() -> Unit,
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxButtonBar(buttonOrder)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ButtonBar] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledButtonBar(
    buttonOrder: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxButtonBar).() -> Unit,
): ButtonBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxButtonBar(buttonOrder)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

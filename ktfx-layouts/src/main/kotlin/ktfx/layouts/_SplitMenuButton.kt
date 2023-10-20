@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.SplitMenuButton
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SplitMenuButton] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.splitMenuButton(): SplitMenuButton = splitMenuButton() { }

/**
 * Create a [SplitMenuButton] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun splitMenuButton(configuration: (@KtfxLayoutDslMarker
        KtfxSplitMenuButton).() -> Unit): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitMenuButton()
    child.configuration()
    return child
}

/**
 * Add a [SplitMenuButton] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.splitMenuButton(configuration: (@KtfxLayoutDslMarker
        KtfxSplitMenuButton).() -> Unit): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitMenuButton()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SplitMenuButton].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledSplitMenuButton(vararg styleClass: String, id: String? = null): SplitMenuButton =
        styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SplitMenuButton] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledSplitMenuButton(vararg styleClass: String, id: String? = null):
        SplitMenuButton = styledSplitMenuButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SplitMenuButton] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSplitMenuButton).() -> Unit,
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitMenuButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SplitMenuButton] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSplitMenuButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSplitMenuButton).() -> Unit,
): SplitMenuButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitMenuButton()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

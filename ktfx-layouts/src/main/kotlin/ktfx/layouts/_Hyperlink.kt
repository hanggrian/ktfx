@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Hyperlink] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.hyperlink(text: String? = null, graphic: Node? = null): Hyperlink =
        hyperlink(text = text, graphic = graphic) { }

/**
 * Create a [Hyperlink] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Hyperlink).() -> Unit,
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Hyperlink(text, graphic)
    child.configuration()
    return child
}

/**
 * Add a [Hyperlink] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    configuration: (@KtfxLayoutDslMarker Hyperlink).() -> Unit,
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Hyperlink(text, graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Hyperlink].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Hyperlink] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): Hyperlink = styledHyperlink(text = text, graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Hyperlink] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Hyperlink).() -> Unit,
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Hyperlink(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Hyperlink] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledHyperlink(
    text: String? = null,
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Hyperlink).() -> Unit,
): Hyperlink {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Hyperlink(text, graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

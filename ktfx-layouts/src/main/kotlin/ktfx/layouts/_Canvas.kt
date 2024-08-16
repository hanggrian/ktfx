@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.canvas.Canvas
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Canvas] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.canvas(width: Double = 0.0, height: Double = 0.0): Canvas =
        canvas(width = width, height = height) { }

/**
 * Create a [Canvas] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Canvas).() -> Unit,
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Canvas(width, height)
    child.configuration()
    return child
}

/**
 * Add a [Canvas] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Canvas).() -> Unit,
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Canvas(width, height)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Canvas].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Canvas = styledCanvas(width = width, height = height, styleClass = styleClass, id = id) { }

/**
 * Add a styled [Canvas] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Canvas = styledCanvas(width = width, height = height, styleClass = styleClass, id = id) { }

/**
 * Create a styled [Canvas] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Canvas).() -> Unit,
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Canvas(width, height)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Canvas] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledCanvas(
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Canvas).() -> Unit,
): Canvas {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Canvas(width, height)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

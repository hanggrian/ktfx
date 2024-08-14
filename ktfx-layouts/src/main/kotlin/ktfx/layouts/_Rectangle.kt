@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Rectangle
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
 * Add a [Rectangle] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
): Rectangle = rectangle(x = x, y = y, width = width, height = height) { }

/**
 * Create a [Rectangle] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Rectangle).() -> Unit,
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Rectangle(x, y, width, height)
    child.configuration()
    return child
}

/**
 * Add a [Rectangle] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@KtfxLayoutDslMarker Rectangle).() -> Unit,
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Rectangle(x, y, width, height)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Rectangle].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Rectangle = styledRectangle(x = x, y = y, width = width, height = height, styleClass =
        styleClass, id = id) { }

/**
 * Add a styled [Rectangle] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): Rectangle = styledRectangle(x = x, y = y, width = width, height = height, styleClass =
        styleClass, id = id) { }

/**
 * Create a styled [Rectangle] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Rectangle).() -> Unit,
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Rectangle(x, y, width, height)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Rectangle] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Rectangle).() -> Unit,
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Rectangle(x, y, width, height)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

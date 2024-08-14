@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Box
import javafx.scene.shape.Box.DEFAULT_SIZE
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
 * Add a [Box] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
): Box = box(width = width, height = height, depth = depth) { }

/**
 * Create a [Box] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    configuration: (@KtfxLayoutDslMarker Box).() -> Unit,
): Box {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Box(width, height, depth)
    child.configuration()
    return child
}

/**
 * Add a [Box] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.box(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    configuration: (@KtfxLayoutDslMarker Box).() -> Unit,
): Box {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Box(width, height, depth)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [Box].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledBox(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    vararg styleClass: String,
    id: String? = null,
): Box = styledBox(width = width, height = height, depth = depth, styleClass = styleClass, id = id)
        { }

/**
 * Add a styled [Box] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledBox(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    vararg styleClass: String,
    id: String? = null,
): Box = styledBox(width = width, height = height, depth = depth, styleClass = styleClass, id = id)
        { }

/**
 * Create a styled [Box] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledBox(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Box).() -> Unit,
): Box {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Box(width, height, depth)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [Box] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledBox(
    width: Double = DEFAULT_SIZE,
    height: Double = DEFAULT_SIZE,
    depth: Double = DEFAULT_SIZE,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker Box).() -> Unit,
): Box {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = Box(width, height, depth)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

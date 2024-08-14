@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.SVGPath
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SVGPath] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.svgPath(): SVGPath = svgPath() { }

/**
 * Create a [SVGPath] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun svgPath(configuration: (@KtfxLayoutDslMarker SVGPath).() -> Unit): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SVGPath()
    child.configuration()
    return child
}

/**
 * Add a [SVGPath] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.svgPath(configuration: (@KtfxLayoutDslMarker SVGPath).() -> Unit):
        SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SVGPath()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SVGPath].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledSvgPath(vararg styleClass: String, id: String? = null): SVGPath =
        styledSvgPath(styleClass = styleClass, id = id) { }

/**
 * Add a styled [SVGPath] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSvgPath(vararg styleClass: String, id: String? = null):
        SVGPath = styledSvgPath(styleClass = styleClass, id = id) { }

/**
 * Create a styled [SVGPath] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledSvgPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SVGPath).() -> Unit,
): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SVGPath()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SVGPath] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledSvgPath(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker SVGPath).() -> Unit,
): SVGPath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = SVGPath()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

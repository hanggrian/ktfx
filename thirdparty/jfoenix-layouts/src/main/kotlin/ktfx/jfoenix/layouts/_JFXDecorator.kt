@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDecorator
import javafx.scene.Node
import javafx.stage.Stage
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXDecorator] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
): JFXDecorator = jfxDecorator(stage = stage, node = node, fullScreen = fullScreen, max = max, min =
        min) { }

/**
 * Create a [JFXDecorator] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    configuration: (@KtfxLayoutDslMarker JFXDecorator).() -> Unit,
): JFXDecorator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDecorator(stage, node, fullScreen, max, min)
    child.configuration()
    return child
}

/**
 * Add a [JFXDecorator] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    configuration: (@KtfxLayoutDslMarker JFXDecorator).() -> Unit,
): JFXDecorator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDecorator(stage, node, fullScreen, max, min)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXDecorator].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): JFXDecorator = styledJFXDecorator(stage = stage, node = node, fullScreen = fullScreen, max = max,
        min = min, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDecorator] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
): JFXDecorator = styledJFXDecorator(stage = stage, node = node, fullScreen = fullScreen, max = max,
        min = min, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDecorator] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDecorator).() -> Unit,
): JFXDecorator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDecorator(stage, node, fullScreen, max, min)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDecorator] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXDecorator(
    stage: Stage,
    node: Node,
    fullScreen: Boolean = true,
    max: Boolean = true,
    min: Boolean = true,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXDecorator).() -> Unit,
): JFXDecorator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXDecorator(stage, node, fullScreen, max, min)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleNode
import javafx.scene.Node
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import ktfx.layouts.ToggleButtonContainer

/**
 * Add a [JFXToggleNode] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxToggleNode(graphic: Node? = null): JFXToggleNode =
        jfxToggleNode(graphic = graphic) { }

/**
 * Add a [JFXToggleNode] to this container.
 *
 * @return the control added.
 */
public inline fun ToggleButtonContainer.jfxToggleNode(graphic: Node? = null): JFXToggleNode =
        jfxToggleNode(graphic = graphic) { }

/**
 * Create a [JFXToggleNode] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxToggleNode(graphic: Node? = null, configuration: (@KtfxLayoutDslMarker
        JFXToggleNode).() -> Unit): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.configuration()
    return child
}

/**
 * Add a [JFXToggleNode] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxToggleNode(graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker JFXToggleNode).() -> Unit): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Add a [JFXToggleNode] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun ToggleButtonContainer.jfxToggleNode(graphic: Node? = null,
        configuration: (@KtfxLayoutDslMarker JFXToggleNode).() -> Unit): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXToggleNode].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXToggleNode = styledJfxToggleNode(graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXToggleNode] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXToggleNode = styledJfxToggleNode(graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Add a styled [JFXToggleNode] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): JFXToggleNode = styledJfxToggleNode(graphic = graphic, styleClass = styleClass, id = id) { }

/**
 * Create a styled [JFXToggleNode] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleNode).() -> Unit,
): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXToggleNode] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleNode).() -> Unit,
): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

/**
 * Add a styled [JFXToggleNode] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun ToggleButtonContainer.styledJfxToggleNode(
    graphic: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXToggleNode).() -> Unit,
): JFXToggleNode {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXToggleNode(graphic)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

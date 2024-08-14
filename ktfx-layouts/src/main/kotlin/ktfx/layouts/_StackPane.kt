@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.StackPane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [StackPane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.stackPane(): StackPane = stackPane() { }

/**
 * Create a [StackPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun stackPane(configuration: (@KtfxLayoutDslMarker KtfxStackPane).() -> Unit): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxStackPane()
    child.configuration()
    return child
}

/**
 * Add a [StackPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.stackPane(configuration: (@KtfxLayoutDslMarker KtfxStackPane).() -> Unit):
        StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxStackPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [StackPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledStackPane(vararg styleClass: String, id: String? = null): StackPane =
        styledStackPane(styleClass = styleClass, id = id) { }

/**
 * Add a styled [StackPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledStackPane(vararg styleClass: String, id: String? = null):
        StackPane = styledStackPane(styleClass = styleClass, id = id) { }

/**
 * Create a styled [StackPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledStackPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxStackPane).() -> Unit,
): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxStackPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [StackPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledStackPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxStackPane).() -> Unit,
): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxStackPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.VBox
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
 * Add a [VBox] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.vbox(spacing: Double = 0.0): VBox = vbox(spacing = spacing) { }

/**
 * Create a [VBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public fun vbox(spacing: Double = 0.0, configuration: (@KtfxLayoutDslMarker KtfxVBox).() -> Unit):
        VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxVBox(spacing)
    child.configuration()
    return child
}

/**
 * Add a [VBox] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public fun NodeContainer.vbox(spacing: Double = 0.0, configuration: (@KtfxLayoutDslMarker
        KtfxVBox).() -> Unit): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxVBox(spacing)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [VBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): VBox = styledVBox(spacing = spacing, styleClass = styleClass, id = id) { }

/**
 * Add a styled [VBox] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
): VBox = styledVBox(spacing = spacing, styleClass = styleClass, id = id) { }

/**
 * Create a styled [VBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public fun styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxVBox).() -> Unit,
): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxVBox(spacing)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [VBox] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledVBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxVBox).() -> Unit,
): VBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxVBox(spacing)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

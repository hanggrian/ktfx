@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.HBox
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [HBox] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.hbox(spacing: Double = 0.0): HBox = hbox(spacing = spacing) { }

/**
 * Create a [HBox] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun hbox(spacing: Double = 0.0, configuration: (@LayoutDslMarker KtfxHBox).() -> Unit):
    HBox {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxHBox(spacing)
        child.configuration()
        return child
    }

/**
 * Add a [HBox] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.hbox(
    spacing: Double = 0.0,
    configuration: (@LayoutDslMarker KtfxHBox).() ->    
    Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHBox(spacing)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [HBox].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): HBox = styledHBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [HBox] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): HBox = styledHBox(spacing = spacing, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [HBox] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHBox(spacing)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [HBox] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledHBox(
    spacing: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxHBox).() -> Unit
): HBox {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxHBox(spacing)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

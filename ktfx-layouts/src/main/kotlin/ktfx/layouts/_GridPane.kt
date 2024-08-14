@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.GridPane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [GridPane] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.gridPane(): GridPane = gridPane() { }

/**
 * Create a [GridPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun gridPane(configuration: (@KtfxLayoutDslMarker KtfxGridPane).() -> Unit): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.configuration()
    return child
}

/**
 * Add a [GridPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.gridPane(configuration: (@KtfxLayoutDslMarker KtfxGridPane).() -> Unit):
        GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [GridPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledGridPane(vararg styleClass: String, id: String? = null): GridPane =
        styledGridPane(styleClass = styleClass, id = id) { }

/**
 * Add a styled [GridPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledGridPane(vararg styleClass: String, id: String? = null):
        GridPane = styledGridPane(styleClass = styleClass, id = id) { }

/**
 * Create a styled [GridPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxGridPane).() -> Unit,
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [GridPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxGridPane).() -> Unit,
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

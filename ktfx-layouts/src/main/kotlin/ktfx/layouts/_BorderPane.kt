@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.BorderPane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [BorderPane] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.borderPane(): BorderPane = borderPane() { }

/**
 * Create a [BorderPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun borderPane(configuration: (@KtfxLayoutDslMarker KtfxBorderPane).() -> Unit):
        BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxBorderPane()
    child.configuration()
    return child
}

/**
 * Add a [BorderPane] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeContainer.borderPane(configuration: (@KtfxLayoutDslMarker
        KtfxBorderPane).() -> Unit): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxBorderPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [BorderPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane =
        styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [BorderPane] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeContainer.styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane
        = styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [BorderPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledBorderPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxBorderPane).() -> Unit,
): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxBorderPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [BorderPane] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledBorderPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxBorderPane).() -> Unit,
): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxBorderPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

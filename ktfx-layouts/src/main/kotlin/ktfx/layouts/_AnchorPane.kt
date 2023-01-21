@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.layout.AnchorPane
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [AnchorPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.anchorPane(): AnchorPane = anchorPane() { }

/**
 * Create an [AnchorPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun anchorPane(configuration: (@KtfxLayoutDslMarker KtfxAnchorPane).() -> Unit):
        AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAnchorPane()
    child.configuration()
    return child
}

/**
 * Add an [AnchorPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.anchorPane(configuration: (@KtfxLayoutDslMarker
        KtfxAnchorPane).() -> Unit): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAnchorPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [AnchorPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledAnchorPane(vararg styleClass: String, id: String? = null): AnchorPane =
        styledAnchorPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [AnchorPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledAnchorPane(vararg styleClass: String, id: String? = null): AnchorPane =
        styledAnchorPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [AnchorPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledAnchorPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxAnchorPane).() -> Unit,
): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAnchorPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [AnchorPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledAnchorPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxAnchorPane).() -> Unit,
): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxAnchorPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

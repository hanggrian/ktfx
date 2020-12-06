@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SplitPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SplitPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.splitPane(): SplitPane = splitPane() { }

/**
 * Create a [SplitPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun splitPane(configuration: (@KtfxLayoutDslMarker KtfxSplitPane).() -> Unit):
    SplitPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxSplitPane()
        child.configuration()
        return child
    }

/**
 * Add a [SplitPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.splitPane(
    configuration: (@KtfxLayoutDslMarker KtfxSplitPane).() ->
    Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SplitPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledSplitPane(vararg styleClass: String, id: String? = null): SplitPane =
    styledSplitPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SplitPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledSplitPane(vararg styleClass: String, id: String? = null): SplitPane =
    styledSplitPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SplitPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledSplitPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SplitPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledSplitPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSplitPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.TabPane
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
 * Add a [TabPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.tabPane(): TabPane = tabPane() { }

/**
 * Create a [TabPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun tabPane(configuration: (@KtfxLayoutDslMarker KtfxTabPane).() -> Unit): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTabPane()
    child.configuration()
    return child
}

/**
 * Add a [TabPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun NodeManager.tabPane(configuration: (@KtfxLayoutDslMarker KtfxTabPane).() -> Unit):
        TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTabPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TabPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public fun styledTabPane(vararg styleClass: String, id: String? = null): TabPane =
        styledTabPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TabPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public fun NodeManager.styledTabPane(vararg styleClass: String, id: String? = null): TabPane =
        styledTabPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TabPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public inline fun styledTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTabPane).() -> Unit,
): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTabPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TabPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public inline fun NodeManager.styledTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxTabPane).() -> Unit,
): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxTabPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

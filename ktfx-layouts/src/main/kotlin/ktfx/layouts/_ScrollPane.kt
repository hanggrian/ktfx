@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane
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
 * Add a [ScrollPane] to this manager.
 *
 * @return the control added.
 */
public fun NodeManager.scrollPane(content: Node? = null): ScrollPane = scrollPane(content = content)
        { }

/**
 * Create a [ScrollPane] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun scrollPane(content: Node? = null, configuration: (@KtfxLayoutDslMarker
        KtfxScrollPane).() -> Unit): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxScrollPane(content)
    child.configuration()
    return child
}

/**
 * Add a [ScrollPane] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeManager.scrollPane(content: Node? = null, configuration: (@KtfxLayoutDslMarker
        KtfxScrollPane).() -> Unit): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxScrollPane(content)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ScrollPane].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): ScrollPane = styledScrollPane(content = content, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollPane] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeManager.styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
): ScrollPane = styledScrollPane(content = content, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollPane] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxScrollPane).() -> Unit,
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxScrollPane(content)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ScrollPane] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeManager.styledScrollPane(
    content: Node? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxScrollPane).() -> Unit,
): ScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxScrollPane(content)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

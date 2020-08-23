@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ScrollBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ScrollBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.scrollBar(): ScrollBar = scrollBar() { }

/**
 * Create a [ScrollBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun scrollBar(configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.configuration()
    return child
}

/**
 * Add a [ScrollBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.scrollBar(configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit):
    ScrollBar {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = ScrollBar()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [ScrollBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [ScrollBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledScrollBar(vararg styleClass: String, id: String? = null): ScrollBar =
    styledScrollBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [ScrollBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ScrollBar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledScrollBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ScrollBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

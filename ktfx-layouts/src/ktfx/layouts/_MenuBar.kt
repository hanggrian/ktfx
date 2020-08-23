@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.MenuBar
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MenuBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.menuBar(): MenuBar = menuBar() { }

/**
 * Create a [MenuBar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun menuBar(configuration: (@KtfxLayoutDslMarker KtfxMenuBar).() -> Unit): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuBar()
    child.configuration()
    return child
}

/**
 * Add a [MenuBar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.menuBar(configuration: (@KtfxLayoutDslMarker KtfxMenuBar).() -> Unit):
    MenuBar {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxMenuBar()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [MenuBar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledMenuBar(vararg styleClass: String, id: String? = null): MenuBar = styledMenuBar(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [MenuBar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledMenuBar(vararg styleClass: String, id: String? = null): MenuBar =
    styledMenuBar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MenuBar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledMenuBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MenuBar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledMenuBar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxMenuBar).() -> Unit
): MenuBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxMenuBar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

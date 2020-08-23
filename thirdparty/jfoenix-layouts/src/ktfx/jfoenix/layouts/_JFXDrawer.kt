@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXDrawer] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxDrawer(): JFXDrawer = jfxDrawer() { }

/**
 * Create a [JFXDrawer] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxDrawer(configuration: (@KtfxLayoutDslMarker KtfxJFXDrawer).() -> Unit): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXDrawer()
    child.configuration()
    return child
}

/**
 * Add a [JFXDrawer] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxDrawer(configuration: (@KtfxLayoutDslMarker KtfxJFXDrawer).() -> Unit):
    JFXDrawer {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxJFXDrawer()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [JFXDrawer].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
    styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDrawer] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXDrawer(vararg styleClass: String, id: String? = null): JFXDrawer =
    styledJFXDrawer(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDrawer] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXDrawer(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXDrawer()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXDrawer] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXDrawer(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXDrawer()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXToolbar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxToolbar(): JFXToolbar = jfxToolbar() { }

/**
 * Create a [JFXToolbar] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxToolbar(configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXToolbar()
    child.configuration()
    return child
}

/**
 * Add a [JFXToolbar] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxToolbar(configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit):
    JFXToolbar {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxJFXToolbar()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [JFXToolbar].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXToolbar(vararg styleClass: String, id: String? = null): JFXToolbar =
    styledJFXToolbar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToolbar] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXToolbar(vararg styleClass: String, id: String? = null): JFXToolbar =
    styledJFXToolbar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXToolbar] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXToolbar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXToolbar] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXToolbar()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

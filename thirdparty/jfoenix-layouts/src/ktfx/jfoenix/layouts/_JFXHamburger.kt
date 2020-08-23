@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXHamburger
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
 * Add a [JFXHamburger] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxHamburger(): JFXHamburger = jfxHamburger() { }

/**
 * Create a [JFXHamburger] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxHamburger(configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit):
    JFXHamburger {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = JFXHamburger()
        child.configuration()
        return child
    }

/**
 * Add a [JFXHamburger] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxHamburger(configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit):
    JFXHamburger {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = JFXHamburger()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [JFXHamburger].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXHamburger(vararg styleClass: String, id: String? = null): JFXHamburger =
    styledJFXHamburger(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXHamburger] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXHamburger(vararg styleClass: String, id: String? = null): JFXHamburger =
    styledJFXHamburger(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXHamburger] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXHamburger(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit
): JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXHamburger] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXHamburger(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXHamburger).() -> Unit
): JFXHamburger {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXHamburger()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

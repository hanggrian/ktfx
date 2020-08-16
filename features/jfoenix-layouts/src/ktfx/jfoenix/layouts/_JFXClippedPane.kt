@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
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
 * Add a [JFXClippedPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxClippedPane(): JFXClippedPane = jfxClippedPane() { }

/**
 * Create a [JFXClippedPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxClippedPane(configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit):
    JFXClippedPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxJFXClippedPane()
        child.configuration()
        return child
    }

/**
 * Add a [JFXClippedPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxClippedPane(
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() ->
    Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXClippedPane()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXClippedPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
    styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXClippedPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
    styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXClippedPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXClippedPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXClippedPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxJFXClippedPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

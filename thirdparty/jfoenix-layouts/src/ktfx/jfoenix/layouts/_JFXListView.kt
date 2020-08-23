@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXListView
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
 * Add a [JFXListView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.jfxListView(): JFXListView<T> = jfxListView() { }

/**
 * Create a [JFXListView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> jfxListView(configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit):
    JFXListView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = JFXListView<T>()
        child.configuration()
        return child
    }

/**
 * Add a [JFXListView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.jfxListView(
    configuration: (@KtfxLayoutDslMarker JFXListView<T>).() ->
    Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXListView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledJFXListView(vararg styleClass: String, id: String? = null): JFXListView<T> =
    styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXListView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledJFXListView(vararg styleClass: String, id: String? = null): JFXListView<T> =
    styledJFXListView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXListView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXListView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledJFXListView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXListView<T>).() -> Unit
): JFXListView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXListView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

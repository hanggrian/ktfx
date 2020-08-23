@file:JvmMultifileClass
@file:JvmName("JFoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
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
 * Add a [JFXChipView] to this manager.
 *
 * @return the control added.
 */
fun <T> NodeManager.jfxChipView(): JFXChipView<T> = jfxChipView() { }

/**
 * Create a [JFXChipView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun <T> jfxChipView(configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit):
    JFXChipView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = JFXChipView<T>()
        child.configuration()
        return child
    }

/**
 * Add a [JFXChipView] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun <T> NodeManager.jfxChipView(
    configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() ->
    Unit
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXChipView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun <T> styledJFXChipView(vararg styleClass: String, id: String? = null): JFXChipView<T> =
    styledJFXChipView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXChipView] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun <T> NodeManager.styledJFXChipView(vararg styleClass: String, id: String? = null): JFXChipView<T> =
    styledJFXChipView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXChipView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun <T> styledJFXChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXChipView] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun <T> NodeManager.styledJFXChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXChipView<T>()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

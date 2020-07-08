@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXChipView
import ktfx.internal.KtfxInternals.newChild
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
 * Add a [JFXChipView] to this manager.
 */
fun <T> NodeManager.jfxChipView(): JFXChipView<T> = jfxChipView() { }

/**
 * Create a [JFXChipView] with configuration block.
 */
inline fun <T> jfxChipView(configuration: (@LayoutDslMarker JFXChipView<T>).() -> Unit):
    JFXChipView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(JFXChipView<T>(), configuration = configuration)
    }

/**
 * Add a [JFXChipView] with configuration block to this manager.
 */
inline fun <T> NodeManager.jfxChipView(configuration: (@LayoutDslMarker JFXChipView<T>).() -> Unit):
    JFXChipView<T> {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(JFXChipView<T>(), configuration = configuration))
    }

/**
 * Create a styled [JFXChipView].
 */
fun <T> styledJFXChipView(vararg styleClass: String, id: String? = null): JFXChipView<T> =
    styledJFXChipView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXChipView] to this manager.
 */
fun <T> NodeManager.styledJFXChipView(vararg styleClass: String, id: String? = null): JFXChipView<T> =
    styledJFXChipView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXChipView] with configuration block.
 */
inline fun <T> styledJFXChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXChipView<T>(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXChipView] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledJFXChipView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXChipView<T>).() -> Unit
): JFXChipView<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXChipView<T>(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

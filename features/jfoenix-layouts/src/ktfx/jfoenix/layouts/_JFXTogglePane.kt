@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTogglePane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXTogglePane] to this manager.
 */
fun NodeManager.jfxTogglePane(): JFXTogglePane = jfxTogglePane() { }

/**
 * Create a [JFXTogglePane] with configuration block.
 */
inline fun jfxTogglePane(configuration: (@LayoutDslMarker KtfxJFXTogglePane).() -> Unit):
        JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXTogglePane(), configuration = configuration)
}

/**
 * Add a [JFXTogglePane] with configuration block to this manager.
 */
inline fun NodeManager.jfxTogglePane(
    configuration: (@LayoutDslMarker KtfxJFXTogglePane).() ->
Unit
): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXTogglePane(), configuration = configuration))
}

/**
 * Create a styled [JFXTogglePane].
 */
fun styledJFXTogglePane(vararg styleClass: String, id: String? = null): JFXTogglePane =
        styledJFXTogglePane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTogglePane] to this manager.
 */
fun NodeManager.styledJFXTogglePane(vararg styleClass: String, id: String? = null): JFXTogglePane =
        styledJFXTogglePane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTogglePane] with configuration block.
 */
inline fun styledJFXTogglePane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXTogglePane(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXTogglePane] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXTogglePane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXTogglePane).() -> Unit
): JFXTogglePane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXTogglePane(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

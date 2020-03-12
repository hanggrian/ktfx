@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
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
 * Add a [JFXClippedPane] to this manager.
 */
fun NodeManager.jfxClippedPane(): JFXClippedPane = jfxClippedPane() { }

/**
 * Create a [JFXClippedPane] with configuration block.
 */
inline fun jfxClippedPane(configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit):
        JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXClippedPane(), configuration = configuration)
}

/**
 * Add a [JFXClippedPane] with configuration block to this manager.
 */
inline fun NodeManager.jfxClippedPane(
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() ->
Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXClippedPane(), configuration = configuration))
}

/**
 * Create a styled [JFXClippedPane].
 */
fun styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
        styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXClippedPane] to this manager.
 */
fun NodeManager.styledJFXClippedPane(vararg styleClass: String, id: String? = null): JFXClippedPane =
        styledJFXClippedPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXClippedPane] with configuration block.
 */
inline fun styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXClippedPane(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXClippedPane] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXClippedPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXClippedPane(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

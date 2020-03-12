@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawersStack
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
 * Add a [JFXDrawersStack] to this manager.
 */
fun NodeManager.jfxDrawersStack(): JFXDrawersStack = jfxDrawersStack() { }

/**
 * Create a [JFXDrawersStack] with configuration block.
 */
inline fun jfxDrawersStack(configuration: (@LayoutDslMarker JFXDrawersStack).() -> Unit):
        JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXDrawersStack(), configuration = configuration)
}

/**
 * Add a [JFXDrawersStack] with configuration block to this manager.
 */
inline fun NodeManager.jfxDrawersStack(
    configuration: (@LayoutDslMarker JFXDrawersStack).() ->
Unit
): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXDrawersStack(), configuration = configuration))
}

/**
 * Create a styled [JFXDrawersStack].
 */
fun styledJFXDrawersStack(vararg styleClass: String, id: String? = null): JFXDrawersStack =
        styledJFXDrawersStack(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXDrawersStack] to this manager.
 */
fun NodeManager.styledJFXDrawersStack(vararg styleClass: String, id: String? = null):
        JFXDrawersStack = styledJFXDrawersStack(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXDrawersStack] with configuration block.
 */
inline fun styledJFXDrawersStack(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXDrawersStack(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXDrawersStack] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXDrawersStack(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXDrawersStack).() -> Unit
): JFXDrawersStack {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXDrawersStack(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
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
 * Add a [JFXScrollPane] to this manager.
 */
fun NodeManager.jfxScrollPane(): JFXScrollPane = jfxScrollPane() { }

/**
 * Create a [JFXScrollPane] with configuration block.
 */
inline fun jfxScrollPane(configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit):
        JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXScrollPane(), configuration = configuration)
}

/**
 * Add a [JFXScrollPane] with configuration block to this manager.
 */
inline fun NodeManager.jfxScrollPane(
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() ->
Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXScrollPane(), configuration = configuration))
}

/**
 * Create a styled [JFXScrollPane].
 */
fun styledJFXScrollPane(vararg styleClass: String, id: String? = null): JFXScrollPane =
        styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXScrollPane] to this manager.
 */
fun NodeManager.styledJFXScrollPane(vararg styleClass: String, id: String? = null): JFXScrollPane =
        styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXScrollPane] with configuration block.
 */
inline fun styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXScrollPane(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXScrollPane] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXScrollPane(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

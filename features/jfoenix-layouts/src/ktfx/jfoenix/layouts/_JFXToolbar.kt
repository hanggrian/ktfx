@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
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
 * Add a [JFXToolbar] to this manager.
 */
fun NodeManager.jfxToolbar(): JFXToolbar = jfxToolbar() { }

/**
 * Create a [JFXToolbar] with configuration block.
 */
inline fun jfxToolbar(configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXToolbar(), configuration = configuration)
}

/**
 * Add a [JFXToolbar] with configuration block to this manager.
 */
inline fun NodeManager.jfxToolbar(configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit):
        JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXToolbar(), configuration = configuration))
}

/**
 * Create a styled [JFXToolbar].
 */
fun styledJFXToolbar(vararg styleClass: String, id: String? = null): JFXToolbar =
        styledJFXToolbar(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToolbar] to this manager.
 */
fun NodeManager.styledJFXToolbar(vararg styleClass: String, id: String? = null): JFXToolbar =
        styledJFXToolbar(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXToolbar] with configuration block.
 */
inline fun styledJFXToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXToolbar(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXToolbar] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXToolbar(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXToolbar).() -> Unit
): JFXToolbar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXToolbar(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

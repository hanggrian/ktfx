@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
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
 * Add a [JFXRippler] to this manager.
 */
fun NodeManager.jfxRippler(): JFXRippler = jfxRippler() { }

/**
 * Create a [JFXRippler] with configuration block.
 */
inline fun jfxRippler(configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXRippler(), configuration = configuration)
}

/**
 * Add a [JFXRippler] with configuration block to this manager.
 */
inline fun NodeManager.jfxRippler(configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit):
        JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXRippler(), configuration = configuration))
}

/**
 * Create a styled [JFXRippler].
 */
fun styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
        styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRippler] to this manager.
 */
fun NodeManager.styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
        styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXRippler] with configuration block.
 */
inline fun styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXRippler(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXRippler] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXRippler(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

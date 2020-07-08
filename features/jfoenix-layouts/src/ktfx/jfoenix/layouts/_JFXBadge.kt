@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
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
 * Add a [JFXBadge] to this manager.
 */
fun NodeManager.jfxBadge(): JFXBadge = jfxBadge() { }

/**
 * Create a [JFXBadge] with configuration block.
 */
inline fun jfxBadge(configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXBadge(), configuration = configuration)
}

/**
 * Add a [JFXBadge] with configuration block to this manager.
 */
inline fun NodeManager.jfxBadge(configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit):
    JFXBadge {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxJFXBadge(), configuration = configuration))
    }

/**
 * Create a styled [JFXBadge].
 */
fun styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXBadge] to this manager.
 */
fun NodeManager.styledJFXBadge(vararg styleClass: String, id: String? = null): JFXBadge =
    styledJFXBadge(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXBadge] with configuration block.
 */
inline fun styledJFXBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxJFXBadge(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXBadge] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXBadge(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxJFXBadge(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

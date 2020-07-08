@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.Pane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Pane] to this manager.
 */
fun NodeManager.pane(): Pane = pane() { }

/**
 * Create a [Pane] with configuration block.
 */
inline fun pane(configuration: (@LayoutDslMarker KtfxPane).() -> Unit): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxPane(), configuration = configuration)
}

/**
 * Add a [Pane] with configuration block to this manager.
 */
inline fun NodeManager.pane(configuration: (@LayoutDslMarker KtfxPane).() -> Unit): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxPane(), configuration = configuration))
}

/**
 * Create a styled [Pane].
 */
fun styledPane(vararg styleClass: String, id: String? = null): Pane = styledPane(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [Pane] to this manager.
 */
fun NodeManager.styledPane(vararg styleClass: String, id: String? = null): Pane =
    styledPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Pane] with configuration block.
 */
inline fun styledPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxPane(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Pane] with configuration block to this manager.
 */
inline fun NodeManager.styledPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxPane).() -> Unit
): Pane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

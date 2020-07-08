@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polyline
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Polyline] to this manager.
 */
fun NodeManager.polyline(): Polyline = polyline() { }

/**
 * Create a [Polyline] with configuration block.
 */
inline fun polyline(configuration: (@LayoutDslMarker Polyline).() -> Unit): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Polyline(), configuration = configuration)
}

/**
 * Add a [Polyline] with configuration block to this manager.
 */
inline fun NodeManager.polyline(configuration: (@LayoutDslMarker Polyline).() -> Unit): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Polyline(), configuration = configuration))
}

/**
 * Create a styled [Polyline].
 */
fun styledPolyline(vararg styleClass: String, id: String? = null): Polyline =
    styledPolyline(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [Polyline] to this manager.
 */
fun NodeManager.styledPolyline(vararg styleClass: String, id: String? = null): Polyline =
    styledPolyline(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Polyline] with configuration block.
 */
inline fun styledPolyline(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Polyline(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Polyline] with configuration block to this manager.
 */
inline fun NodeManager.styledPolyline(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Polyline).() -> Unit
): Polyline {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Polyline(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

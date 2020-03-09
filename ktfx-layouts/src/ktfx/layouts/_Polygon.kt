@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Polygon
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Polygon] to this manager.
 */
fun NodeManager.polygon(): Polygon = polygon() { }

/**
 * Create a [Polygon] with configuration block.
 */
inline fun polygon(configuration: (@LayoutDslMarker Polygon).() -> Unit): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Polygon(), configuration = configuration)
}

/**
 * Add a [Polygon] with configuration block to this manager.
 */
inline fun NodeManager.polygon(configuration: (@LayoutDslMarker Polygon).() -> Unit): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Polygon(), configuration = configuration))
}

/**
 * Create a styled [Polygon].
 */
fun styledPolygon(vararg styleClass: String, id: String? = null): Polygon = styledPolygon(styleClass =
        *styleClass, id = id) { }

/**
 * Add a styled [Polygon] to this manager.
 */
fun NodeManager.styledPolygon(vararg styleClass: String, id: String? = null): Polygon =
        styledPolygon(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [Polygon] with configuration block.
 */
inline fun styledPolygon(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Polygon(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [Polygon] with configuration block to this manager.
 */
inline fun NodeManager.styledPolygon(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Polygon).() -> Unit
): Polygon {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Polygon(), styleClass = *styleClass, id = id, configuration =
            configuration))
}

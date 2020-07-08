@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Rectangle
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [Rectangle] to this manager.
 */
fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0
): Rectangle = rectangle(x = x, y = y, width = width, height = height) { }

/**
 * Create a [Rectangle] with configuration block.
 */
inline fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Rectangle(x, y, width, height), configuration = configuration)
}

/**
 * Add a [Rectangle] with configuration block to this manager.
 */
inline fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Rectangle(x, y, width, height), configuration = configuration))
}

/**
 * Create a styled [Rectangle].
 */
fun styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Rectangle = styledRectangle(
    x = x, y = y, width = width, height = height,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [Rectangle] to this manager.
 */
fun NodeManager.styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null
): Rectangle = styledRectangle(
    x = x, y = y, width = width, height = height,
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Create a styled [Rectangle] with configuration block.
 */
inline fun styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        Rectangle(x, y, width, height), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [Rectangle] with configuration block to this manager.
 */
inline fun NodeManager.styledRectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            Rectangle(x, y, width, height), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

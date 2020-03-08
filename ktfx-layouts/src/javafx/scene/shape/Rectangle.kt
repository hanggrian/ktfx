@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Rectangle
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Rectangle] with configuration block. */
inline fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Rectangle(x, y, width, height).apply(configuration)
}

/** Add a [Rectangle] to this manager. */
fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0
): Rectangle = addChild(Rectangle(x, y, width, height))

/** Add a [Rectangle] with configuration block to this manager. */
inline fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    configuration: (@LayoutDslMarker Rectangle).() -> Unit
): Rectangle {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Rectangle(x, y, width, height), configuration)
}

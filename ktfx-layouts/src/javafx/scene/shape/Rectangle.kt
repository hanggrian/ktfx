@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Rectangle
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Rectangle] with initialization block. */
inline fun rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: Rectangle.() -> Unit
): Rectangle {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Rectangle(x, y, width, height).apply(init)
}
/** Add a [Rectangle] to this manager. */
fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0
): Rectangle = addNode(Rectangle(x, y, width, height))

/** Add a [Rectangle] with initialization block to this manager. */
inline fun NodeManager.rectangle(
    x: Double = 0.0,
    y: Double = 0.0,
    width: Double = 0.0,
    height: Double = 0.0,
    init: Rectangle.() -> Unit
): Rectangle {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Rectangle(x, y, width, height), init)
}

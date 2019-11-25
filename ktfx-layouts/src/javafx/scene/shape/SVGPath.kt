@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.SVGPath
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [SVGPath] with initialization block. */
inline fun svgPath(
    init: (@LayoutsDslMarker SVGPath).() -> Unit
): SVGPath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return SVGPath().apply(init)
}

/** Add a [SVGPath] to this manager. */
fun NodeManager.svgPath(): SVGPath =
    addNode(SVGPath())

/** Add a [SVGPath] with initialization block to this manager. */
inline fun NodeManager.svgPath(
    init: (@LayoutsDslMarker SVGPath).() -> Unit
): SVGPath {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(SVGPath(), init)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.ClosePath
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ClosePath] with configuration block. */
inline fun closePath(
    configuration: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ClosePath().apply(configuration)
}

/** Add a [ClosePath] to this manager. */
fun PathElementManager.closePath(): ClosePath = addChild(ClosePath())

/** Add a [ClosePath] with configuration block to this manager. */
inline fun PathElementManager.closePath(
    configuration: (@LayoutDslMarker ClosePath).() -> Unit
): ClosePath {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ClosePath(), configuration)
}

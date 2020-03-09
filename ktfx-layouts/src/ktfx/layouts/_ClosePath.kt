@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.ClosePath
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ClosePath] to this manager.
 */
fun PathElementManager.closePath(): ClosePath = closePath() { }

/**
 * Create a [ClosePath] with configuration block.
 */
inline fun closePath(configuration: (@LayoutDslMarker ClosePath).() -> Unit): ClosePath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ClosePath(), configuration = configuration)
}

/**
 * Add a [ClosePath] with configuration block to this manager.
 */
inline fun PathElementManager.closePath(configuration: (@LayoutDslMarker ClosePath).() -> Unit):
        ClosePath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ClosePath(), configuration = configuration))
}

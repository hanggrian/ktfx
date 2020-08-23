@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.ClosePath
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ClosePath] to this manager.
 *
 * @return the control added.
 */
fun PathElementManager.closePath(): ClosePath = closePath() { }

/**
 * Create a [ClosePath] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun closePath(configuration: (@KtfxLayoutDslMarker ClosePath).() -> Unit): ClosePath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ClosePath()
    child.configuration()
    return child
}

/**
 * Add a [ClosePath] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun PathElementManager.closePath(configuration: (@KtfxLayoutDslMarker ClosePath).() -> Unit):
    ClosePath {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = ClosePath()
        child.configuration()
        return addChild(child)
    }

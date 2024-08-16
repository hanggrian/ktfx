@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.shape.ClosePath
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ClosePath] to this container.
 *
 * @return the control added.
 */
public inline fun PathElementContainer.closePath(): ClosePath = closePath() { }

/**
 * Create a [ClosePath] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public inline fun closePath(configuration: (@KtfxLayoutDslMarker ClosePath).() -> Unit): ClosePath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ClosePath()
    child.configuration()
    return child
}

/**
 * Add a [ClosePath] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public inline fun PathElementContainer.closePath(configuration: (@KtfxLayoutDslMarker
        ClosePath).() -> Unit): ClosePath {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ClosePath()
    child.configuration()
    return addChild(child)
}

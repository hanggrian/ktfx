@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import ktfx.layouts.KtfxLayoutDslMarker
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Configure [JFXToolbar] left items.
 *
 * @param configuration the configuration block.
 */
inline fun JFXToolbar.leftItems(
    configuration: (@KtfxLayoutDslMarker KtfxJfxToolbar.HBoxConstraints).() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJfxToolbar.HBoxConstraints(leftItems).configuration()
}

/**
 * Configure [JFXToolbar] right items.
 *
 * @param configuration the configuration block.
 */
inline fun JFXToolbar.rightItems(
    configuration: (@KtfxLayoutDslMarker KtfxJfxToolbar.HBoxConstraints).() -> Unit
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJfxToolbar.HBoxConstraints(rightItems).configuration()
}

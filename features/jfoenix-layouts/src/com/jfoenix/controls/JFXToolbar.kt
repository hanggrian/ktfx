@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToolbar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker

/** Add children to [JFXToolbar] left items with DSL. */
inline fun JFXToolbar.leftItems(configuration: (@LayoutDslMarker KtfxJFXToolbar.HBoxConstraints).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJFXToolbar.HBoxConstraints(leftItems).configuration()
}

/** Add children to [JFXToolbar] right items with DSL. */
inline fun JFXToolbar.rightItems(configuration: (@LayoutDslMarker KtfxJFXToolbar.HBoxConstraints).() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    KtfxJFXToolbar.HBoxConstraints(rightItems).configuration()
}

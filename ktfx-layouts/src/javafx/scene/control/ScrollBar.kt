@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ScrollBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ScrollBar] with configurationialization block. */
inline fun scrollBar(
    configuration: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ScrollBar().apply(configuration)
}

/** Add a [ScrollBar] to this manager. */
fun NodeManager.scrollBar(): ScrollBar = addChild(ScrollBar())

/** Add a [ScrollBar] with configurationialization block to this manager. */
inline fun NodeManager.scrollBar(
    configuration: (@LayoutDslMarker ScrollBar).() -> Unit
): ScrollBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ScrollBar(), configuration)
}

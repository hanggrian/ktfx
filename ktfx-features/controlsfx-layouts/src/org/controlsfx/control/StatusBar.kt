@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.StatusBar

/** Create a [StatusBar] with initialization block. */
inline fun statusBar(
    init: (@LayoutsDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return StatusBar().apply(init)
}

/** Add a [StatusBar] to this manager. */
fun NodeManager.statusBar(): StatusBar =
    addNode(StatusBar())

/** Add a [StatusBar] with initialization block to this manager. */
inline fun NodeManager.statusBar(
    init: (@LayoutsDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(StatusBar(), init)
}

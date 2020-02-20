@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.StatusBar

/** Create a [StatusBar] with configuration block. */
inline fun statusBar(
    configuration: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return StatusBar().apply(configuration)
}

/** Add a [StatusBar] to this manager. */
fun NodeManager.statusBar(): StatusBar = addChild(StatusBar())

/** Add a [StatusBar] with configuration block to this manager. */
inline fun NodeManager.statusBar(
    configuration: (@LayoutDslMarker StatusBar).() -> Unit
): StatusBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(StatusBar(), configuration)
}

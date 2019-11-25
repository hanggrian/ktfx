@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXProgressBar] with initialization block. */
inline fun jfxProgressBar(
    progress: Double = 0.0,
    init: (@LayoutsDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXProgressBar(progress).apply(init)
}

/** Add a [JFXProgressBar] to this manager. */
fun NodeManager.jfxProgressBar(
    progress: Double = 0.0
): JFXProgressBar = addNode(JFXProgressBar(progress))

/** Add a [JFXProgressBar] with initialization block to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    init: (@LayoutsDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXProgressBar(progress), init)
}

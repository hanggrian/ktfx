@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXProgressBar] with configuration block. */
inline fun jfxProgressBar(
    progress: Double = 0.0,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXProgressBar(progress).apply(configuration)
}

/** Add a [JFXProgressBar] to this manager. */
fun NodeManager.jfxProgressBar(
    progress: Double = 0.0
): JFXProgressBar = addChild(JFXProgressBar(progress))

/** Add a [JFXProgressBar] with configuration block to this manager. */
inline fun NodeManager.jfxProgressBar(
    progress: Double = 0.0,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXProgressBar(progress), configuration)
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ProgressBar] with initialization block. */
inline fun progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    configuration: (@LayoutsDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ProgressBar(progress).apply(configuration)
}

/** Add a [ProgressBar] to this manager. */
fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressBar = addChild(ProgressBar(progress))

/** Add a [ProgressBar] with initialization block to this manager. */
inline fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    configuration: (@LayoutsDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ProgressBar(progress), configuration)
}

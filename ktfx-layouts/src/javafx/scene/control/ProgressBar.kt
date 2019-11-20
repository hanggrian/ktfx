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
    init: (@KtfxLayoutsDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ProgressBar(progress).apply(init)
}

/** Add a [ProgressBar] to this manager. */
fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressBar = addNode(ProgressBar(progress))

/** Add a [ProgressBar] with initialization block to this manager. */
inline fun NodeManager.progressBar(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: (@KtfxLayoutsDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ProgressBar(progress), init)
}

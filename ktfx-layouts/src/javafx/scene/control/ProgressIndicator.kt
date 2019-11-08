@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ProgressIndicator] with initialization block. */
inline fun progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: ProgressIndicator.() -> Unit
): ProgressIndicator {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return ProgressIndicator(progress).apply(init)
}
/** Add a [ProgressIndicator] to this manager. */
fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressIndicator = addNode(ProgressIndicator(progress))

/** Add a [ProgressIndicator] with initialization block to this manager. */
inline fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    init: ProgressIndicator.() -> Unit
): ProgressIndicator {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(ProgressIndicator(progress), init)
}

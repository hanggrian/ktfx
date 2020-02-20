@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [ProgressIndicator] with configuration block. */
inline fun progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return ProgressIndicator(progress).apply(configuration)
}

/** Add a [ProgressIndicator] to this manager. */
fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS
): ProgressIndicator = addChild(ProgressIndicator(progress))

/** Add a [ProgressIndicator] with configuration block to this manager. */
inline fun NodeManager.progressIndicator(
    progress: Double = ProgressBar.INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(ProgressIndicator(progress), configuration)
}

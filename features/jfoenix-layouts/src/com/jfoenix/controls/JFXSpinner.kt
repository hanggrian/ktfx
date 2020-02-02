@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXSpinner] with initialization block to this manager. */
inline fun jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: (@LayoutsDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXSpinner(progress).apply(init)
}

/** Add a [JFXSpinner] to this manager. */
fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS
): JFXSpinner = addChild(JFXSpinner(progress))

/** Add a [JFXSpinner] with initialization block to this manager. */
inline fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    init: (@LayoutsDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXSpinner(progress), init)
}

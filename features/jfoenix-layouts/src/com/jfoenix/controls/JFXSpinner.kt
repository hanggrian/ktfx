@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXSpinner] with configuration block to this manager. */
inline fun jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXSpinner(progress).apply(configuration)
}

/** Add a [JFXSpinner] to this manager. */
fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS
): JFXSpinner = addChild(JFXSpinner(progress))

/** Add a [JFXSpinner] with configuration block to this manager. */
inline fun NodeManager.jfxSpinner(
    progress: Double = JFXSpinner.INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXSpinner).() -> Unit
): JFXSpinner {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXSpinner(progress), configuration)
}

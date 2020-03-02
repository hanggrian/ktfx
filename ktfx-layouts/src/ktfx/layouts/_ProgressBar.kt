@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [ProgressBar] to this manager.
 */
fun NodeManager.progressBar(progress: Double = INDETERMINATE_PROGRESS): ProgressBar =
        progressBar(progress = progress) { }

/**
 * Create a [ProgressBar] with configuration block.
 */
inline fun progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker    
            ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ProgressBar(progress), configuration = configuration)
}

/**
 * Add a [ProgressBar] with configuration block to this manager.
 */
inline fun NodeManager.progressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressBar(progress), configuration = configuration))
}

/**
 * Create a styled [ProgressBar].
 */
fun styledProgressBar(progress: Double = INDETERMINATE_PROGRESS, vararg styleClass: String):
        ProgressBar = styledProgressBar(progress = progress, styleClass = *styleClass) { }

/**
 * Add a styled [ProgressBar] to this manager.
 */
fun NodeManager.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg    
            styleClass: String
): ProgressBar = styledProgressBar(progress = progress, styleClass =
        *styleClass) { }

/**
 * Create a styled [ProgressBar] with configuration block.
 */
inline fun styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ProgressBar(progress), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [ProgressBar] with configuration block to this manager.
 */
inline fun NodeManager.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ProgressBar).() -> Unit
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressBar(progress), styleClass = *styleClass, configuration =
            configuration))
}

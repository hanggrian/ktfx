@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator
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
 * Create a styled [ProgressIndicator].
 */
fun styledProgressIndicator(progress: Double = INDETERMINATE_PROGRESS, vararg styleClass: String):
        ProgressIndicator = styledProgressIndicator(progress = progress, styleClass = *styleClass) {
        }

/**
 * Add a styled [ProgressIndicator] to this manager.
 */
fun NodeManager.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg    
            styleClass: String
): ProgressIndicator = styledProgressIndicator(progress = progress,
        styleClass = *styleClass) { }

/**
 * Create a styled [ProgressIndicator] with configuration block.
 */
inline fun styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ProgressIndicator(progress), styleClass = *styleClass, configuration =
            configuration)
}

/**
 * Add a styled [ProgressIndicator] with configuration block to this manager.
 */
inline fun NodeManager.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressIndicator(progress), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [ProgressIndicator] to this manager.
 */
fun NodeManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS): ProgressIndicator =
        progressIndicator(progress = progress) { }

/**
 * Create a [ProgressIndicator] with configuration block.
 */
inline fun progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(ProgressIndicator(progress), configuration = configuration)
}

/**
 * Add a [ProgressIndicator] with configuration block to this manager.
 */
inline fun NodeManager.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressIndicator(progress), configuration = configuration))
}

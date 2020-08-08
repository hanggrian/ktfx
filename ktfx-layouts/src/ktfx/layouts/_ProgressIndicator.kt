@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator
import ktfx.internal.KtfxInternals.newChild
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ProgressIndicator] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.progressIndicator(progress: Double = INDETERMINATE_PROGRESS): ProgressIndicator =
    progressIndicator(progress = progress) { }

/**
 * Create a [ProgressIndicator] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
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
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(ProgressIndicator(progress), configuration = configuration))
}

/**
 * Create a styled [ProgressIndicator].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): ProgressIndicator = styledProgressIndicator(
    progress = progress, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Add a styled [ProgressIndicator] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): ProgressIndicator = styledProgressIndicator(
    progress = progress, styleClass = *styleClass,
    id =
        id
) { }

/**
 * Create a styled [ProgressIndicator] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        ProgressIndicator(progress), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [ProgressIndicator] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            ProgressIndicator(progress), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

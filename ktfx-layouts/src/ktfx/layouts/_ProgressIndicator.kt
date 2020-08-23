@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

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
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.configuration()
    return child
}

/**
 * Add a [ProgressIndicator] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.progressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.configuration()
    return addChild(child)
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
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
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
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

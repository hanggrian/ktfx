@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import javafx.scene.control.ProgressIndicator
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [ProgressIndicator] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.progressIndicator(progress: Double = INDETERMINATE_PROGRESS):
        ProgressIndicator = progressIndicator(progress = progress) { }

/**
 * Create a [ProgressIndicator] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun progressIndicator(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.configuration()
    return child
}

/**
 * Add a [ProgressIndicator] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.progressIndicator(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit): ProgressIndicator {
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
public fun styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): ProgressIndicator = styledProgressIndicator(progress = progress, styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [ProgressIndicator] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): ProgressIndicator = styledProgressIndicator(progress = progress, styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [ProgressIndicator] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit,
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ProgressIndicator] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledProgressIndicator(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ProgressIndicator).() -> Unit,
): ProgressIndicator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressIndicator(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

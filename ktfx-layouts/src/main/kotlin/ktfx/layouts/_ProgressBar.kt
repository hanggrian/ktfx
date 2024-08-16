@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress(
    "NOTHING_TO_INLINE",
    "ktlint",
)

package ktfx.layouts

import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
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
 * Add a [ProgressBar] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.progressBar(progress: Double = INDETERMINATE_PROGRESS): ProgressBar
        = progressBar(progress = progress) { }

/**
 * Create a [ProgressBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun progressBar(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker ProgressBar).() -> Unit): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressBar(progress)
    child.configuration()
    return child
}

/**
 * Add a [ProgressBar] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.progressBar(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker ProgressBar).() -> Unit): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressBar(progress)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [ProgressBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public inline fun styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): ProgressBar = styledProgressBar(progress = progress, styleClass = styleClass, id = id) { }

/**
 * Add a styled [ProgressBar] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): ProgressBar = styledProgressBar(progress = progress, styleClass = styleClass, id = id) { }

/**
 * Create a styled [ProgressBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ProgressBar).() -> Unit,
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressBar(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [ProgressBar] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker ProgressBar).() -> Unit,
): ProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = ProgressBar(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

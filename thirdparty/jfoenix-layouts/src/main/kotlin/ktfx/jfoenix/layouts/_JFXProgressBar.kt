@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer

/**
 * Add a [JFXProgressBar] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxProgressBar(progress: Double = INDETERMINATE_PROGRESS): JFXProgressBar =
        jfxProgressBar(progress = progress) { }

/**
 * Create a [JFXProgressBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxProgressBar(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker JFXProgressBar).() -> Unit): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXProgressBar(progress)
    child.configuration()
    return child
}

/**
 * Add a [JFXProgressBar] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxProgressBar(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker JFXProgressBar).() -> Unit): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXProgressBar(progress)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXProgressBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXProgressBar] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXProgressBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXProgressBar).() -> Unit,
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXProgressBar(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXProgressBar] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXProgressBar).() -> Unit,
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXProgressBar(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

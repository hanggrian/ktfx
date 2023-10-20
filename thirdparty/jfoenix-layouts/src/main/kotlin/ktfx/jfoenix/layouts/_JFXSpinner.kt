@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSpinner
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
 * Add a [JFXSpinner] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.jfxSpinner(progress: Double = INDETERMINATE_PROGRESS): JFXSpinner =
        jfxSpinner(progress = progress) { }

/**
 * Create a [JFXSpinner] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun jfxSpinner(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker JFXSpinner).() -> Unit): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSpinner(progress)
    child.configuration()
    return child
}

/**
 * Add a [JFXSpinner] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.jfxSpinner(progress: Double = INDETERMINATE_PROGRESS,
        configuration: (@KtfxLayoutDslMarker JFXSpinner).() -> Unit): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSpinner(progress)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [JFXSpinner].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXSpinner] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
): JFXSpinner = styledJFXSpinner(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXSpinner] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXSpinner).() -> Unit,
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSpinner(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [JFXSpinner] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledJFXSpinner(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker JFXSpinner).() -> Unit,
): JFXSpinner {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = JFXSpinner(progress)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

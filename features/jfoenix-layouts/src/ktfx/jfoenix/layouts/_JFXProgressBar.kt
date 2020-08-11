@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
import javafx.scene.control.ProgressBar.INDETERMINATE_PROGRESS
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXProgressBar] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxProgressBar(progress: Double = INDETERMINATE_PROGRESS): JFXProgressBar =
    jfxProgressBar(progress = progress) { }

/**
 * Create a [JFXProgressBar] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
inline fun jfxProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXProgressBar(progress), configuration = configuration)
}

/**
 * Add a [JFXProgressBar] with configuration block to this manager.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
inline fun NodeManager.jfxProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXProgressBar(progress), configuration = configuration))
}

/**
 * Create a styled [JFXProgressBar].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXProgressBar] to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
fun NodeManager.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXProgressBar] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
inline fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXProgressBar(progress), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXProgressBar] with configuration block to this manager.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXProgressBar(progress), styleClass = *styleClass, id = id,
            configuration = configuration
        )
    )
}

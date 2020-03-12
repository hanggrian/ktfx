@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXProgressBar
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
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/**
 * Add a [JFXProgressBar] to this manager.
 */
fun NodeManager.jfxProgressBar(progress: Double = INDETERMINATE_PROGRESS): JFXProgressBar =
        jfxProgressBar(progress = progress) { }

/**
 * Create a [JFXProgressBar] with configuration block.
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
 */
fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXProgressBar] to this manager.
 */
fun NodeManager.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null
): JFXProgressBar = styledJFXProgressBar(progress = progress, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXProgressBar] with configuration block.
 */
inline fun styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXProgressBar(progress), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [JFXProgressBar] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXProgressBar(
    progress: Double = INDETERMINATE_PROGRESS,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXProgressBar).() -> Unit
): JFXProgressBar {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXProgressBar(progress), styleClass = *styleClass, id = id,
            configuration = configuration))
}

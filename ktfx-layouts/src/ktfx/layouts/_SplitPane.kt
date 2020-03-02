@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SplitPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [SplitPane] to this manager.
 */
fun NodeManager.splitPane(): SplitPane = splitPane() { }

/**
 * Create a [SplitPane] with configuration block.
 */
inline fun splitPane(configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxSplitPane(), configuration = configuration)
}

/**
 * Add a [SplitPane] with configuration block to this manager.
 */
inline fun NodeManager.splitPane(configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit):
        SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxSplitPane(), configuration = configuration))
}

/**
 * Create a styled [SplitPane].
 */
fun styledSplitPane(vararg styleClass: String): SplitPane = styledSplitPane(styleClass =
        *styleClass) { }

/**
 * Add a styled [SplitPane] to this manager.
 */
fun NodeManager.styledSplitPane(vararg styleClass: String): SplitPane = styledSplitPane(styleClass =
        *styleClass) { }

/**
 * Create a styled [SplitPane] with configuration block.
 */
inline fun styledSplitPane(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxSplitPane(), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [SplitPane] with configuration block to this manager.
 */
inline fun NodeManager.styledSplitPane(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxSplitPane(), styleClass = *styleClass, configuration =
            configuration))
}

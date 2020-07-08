@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SplitPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

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
fun styledSplitPane(vararg styleClass: String, id: String? = null): SplitPane =
    styledSplitPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SplitPane] to this manager.
 */
fun NodeManager.styledSplitPane(vararg styleClass: String, id: String? = null): SplitPane =
    styledSplitPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SplitPane] with configuration block.
 */
inline fun styledSplitPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxSplitPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [SplitPane] with configuration block to this manager.
 */
inline fun NodeManager.styledSplitPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxSplitPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

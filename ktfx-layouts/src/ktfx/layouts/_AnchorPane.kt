@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.AnchorPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add an [AnchorPane] to this manager.
 */
fun NodeManager.anchorPane(): AnchorPane = anchorPane() { }

/**
 * Create an [AnchorPane] with configuration block.
 */
inline fun anchorPane(configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxAnchorPane(), configuration = configuration)
}

/**
 * Add an [AnchorPane] with configuration block to this manager.
 */
inline fun NodeManager.anchorPane(configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit):
    AnchorPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxAnchorPane(), configuration = configuration))
    }

/**
 * Create a styled [AnchorPane].
 */
fun styledAnchorPane(vararg styleClass: String, id: String? = null): AnchorPane =
    styledAnchorPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [AnchorPane] to this manager.
 */
fun NodeManager.styledAnchorPane(vararg styleClass: String, id: String? = null): AnchorPane =
    styledAnchorPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [AnchorPane] with configuration block.
 */
inline fun styledAnchorPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxAnchorPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [AnchorPane] with configuration block to this manager.
 */
inline fun NodeManager.styledAnchorPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxAnchorPane).() -> Unit
): AnchorPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxAnchorPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

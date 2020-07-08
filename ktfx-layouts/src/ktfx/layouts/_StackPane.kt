@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.StackPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [StackPane] to this manager.
 */
fun NodeManager.stackPane(): StackPane = stackPane() { }

/**
 * Create a [StackPane] with configuration block.
 */
inline fun stackPane(configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxStackPane(), configuration = configuration)
}

/**
 * Add a [StackPane] with configuration block to this manager.
 */
inline fun NodeManager.stackPane(configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit):
    StackPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxStackPane(), configuration = configuration))
    }

/**
 * Create a styled [StackPane].
 */
fun styledStackPane(vararg styleClass: String, id: String? = null): StackPane =
    styledStackPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [StackPane] to this manager.
 */
fun NodeManager.styledStackPane(vararg styleClass: String, id: String? = null): StackPane =
    styledStackPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [StackPane] with configuration block.
 */
inline fun styledStackPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit
): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxStackPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [StackPane] with configuration block to this manager.
 */
inline fun NodeManager.styledStackPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit
): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxStackPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.GridPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [GridPane] to this manager.
 */
fun NodeManager.gridPane(): GridPane = gridPane() { }

/**
 * Create a [GridPane] with configuration block.
 */
inline fun gridPane(configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxGridPane(), configuration = configuration)
}

/**
 * Add a [GridPane] with configuration block to this manager.
 */
inline fun NodeManager.gridPane(configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit):
    GridPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxGridPane(), configuration = configuration))
    }

/**
 * Create a styled [GridPane].
 */
fun styledGridPane(vararg styleClass: String, id: String? = null): GridPane =
    styledGridPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [GridPane] to this manager.
 */
fun NodeManager.styledGridPane(vararg styleClass: String, id: String? = null): GridPane =
    styledGridPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [GridPane] with configuration block.
 */
inline fun styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxGridPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [GridPane] with configuration block to this manager.
 */
inline fun NodeManager.styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxGridPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

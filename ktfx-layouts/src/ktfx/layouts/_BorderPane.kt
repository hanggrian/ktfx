@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.BorderPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [BorderPane] to this manager.
 */
fun NodeManager.borderPane(): BorderPane = borderPane() { }

/**
 * Create a [BorderPane] with configuration block.
 */
inline fun borderPane(configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxBorderPane(), configuration = configuration)
}

/**
 * Add a [BorderPane] with configuration block to this manager.
 */
inline fun NodeManager.borderPane(configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit):
    BorderPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxBorderPane(), configuration = configuration))
    }

/**
 * Create a styled [BorderPane].
 */
fun styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane =
    styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [BorderPane] to this manager.
 */
fun NodeManager.styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane =
    styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [BorderPane] with configuration block.
 */
inline fun styledBorderPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxBorderPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [BorderPane] with configuration block to this manager.
 */
inline fun NodeManager.styledBorderPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit
): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxBorderPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

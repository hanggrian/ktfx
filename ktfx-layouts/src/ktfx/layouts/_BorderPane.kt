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
 *
 * @return the control added.
 */
fun NodeManager.borderPane(): BorderPane = borderPane() { }

/**
 * Create a [BorderPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun borderPane(configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit): BorderPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxBorderPane(), configuration = configuration)
}

/**
 * Add a [BorderPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.borderPane(configuration: (@LayoutDslMarker KtfxBorderPane).() -> Unit):
    BorderPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxBorderPane(), configuration = configuration))
    }

/**
 * Create a styled [BorderPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane =
    styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [BorderPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledBorderPane(vararg styleClass: String, id: String? = null): BorderPane =
    styledBorderPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [BorderPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
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
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
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

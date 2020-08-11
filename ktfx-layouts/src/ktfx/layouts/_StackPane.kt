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
 *
 * @return the control added.
 */
fun NodeManager.stackPane(): StackPane = stackPane() { }

/**
 * Create a [StackPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun stackPane(configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit): StackPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxStackPane(), configuration = configuration)
}

/**
 * Add a [StackPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.stackPane(configuration: (@LayoutDslMarker KtfxStackPane).() -> Unit):
    StackPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxStackPane(), configuration = configuration))
    }

/**
 * Create a styled [StackPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledStackPane(vararg styleClass: String, id: String? = null): StackPane =
    styledStackPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [StackPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledStackPane(vararg styleClass: String, id: String? = null): StackPane =
    styledStackPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [StackPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
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
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
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

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.layout.GridPane
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [GridPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.gridPane(): GridPane = gridPane() { }

/**
 * Create a [GridPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun gridPane(configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.configuration()
    return child
}

/**
 * Add a [GridPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.gridPane(configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit):
    GridPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        val child = KtfxGridPane()
        child.configuration()
        return addChild(child)
    }

/**
 * Create a styled [GridPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledGridPane(vararg styleClass: String, id: String? = null): GridPane =
    styledGridPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [GridPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledGridPane(vararg styleClass: String, id: String? = null): GridPane =
    styledGridPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [GridPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [GridPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledGridPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxGridPane).() -> Unit
): GridPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxGridPane()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

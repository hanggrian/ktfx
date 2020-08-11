@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TabPane
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TabPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.tabPane(): TabPane = tabPane() { }

/**
 * Create a [TabPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun tabPane(configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTabPane(), configuration = configuration)
}

/**
 * Add a [TabPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.tabPane(configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxTabPane(), configuration = configuration))
}

/**
 * Create a styled [TabPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledTabPane(vararg styleClass: String, id: String? = null): TabPane = styledTabPane(
    styleClass =
        *styleClass,
    id = id
) { }

/**
 * Add a styled [TabPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledTabPane(vararg styleClass: String, id: String? = null): TabPane =
    styledTabPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TabPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxTabPane(), styleClass = *styleClass, id = id, configuration = configuration)
}

/**
 * Add a styled [TabPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledTabPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxTabPane).() -> Unit
): TabPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxTabPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

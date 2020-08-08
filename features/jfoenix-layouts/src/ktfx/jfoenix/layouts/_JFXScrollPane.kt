@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXScrollPane
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXScrollPane] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxScrollPane(): JFXScrollPane = jfxScrollPane() { }

/**
 * Create a [JFXScrollPane] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxScrollPane(configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit):
    JFXScrollPane {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(KtfxJFXScrollPane(), configuration = configuration)
    }

/**
 * Add a [JFXScrollPane] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxScrollPane(
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() ->
    Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(KtfxJFXScrollPane(), configuration = configuration))
}

/**
 * Create a styled [JFXScrollPane].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXScrollPane(vararg styleClass: String, id: String? = null): JFXScrollPane =
    styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXScrollPane] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXScrollPane(vararg styleClass: String, id: String? = null): JFXScrollPane =
    styledJFXScrollPane(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXScrollPane] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxJFXScrollPane(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXScrollPane] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXScrollPane(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXScrollPane).() -> Unit
): JFXScrollPane {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxJFXScrollPane(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

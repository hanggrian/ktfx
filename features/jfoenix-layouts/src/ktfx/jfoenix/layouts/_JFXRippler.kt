@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
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
 * Add a [JFXRippler] to this manager.
 *
 * @return the control added.
 */
fun NodeManager.jfxRippler(): JFXRippler = jfxRippler() { }

/**
 * Create a [JFXRippler] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun jfxRippler(configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(KtfxJFXRippler(), configuration = configuration)
}

/**
 * Add a [JFXRippler] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun NodeManager.jfxRippler(configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit):
    JFXRippler {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxJFXRippler(), configuration = configuration))
    }

/**
 * Create a styled [JFXRippler].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
    styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXRippler] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun NodeManager.styledJFXRippler(vararg styleClass: String, id: String? = null): JFXRippler =
    styledJFXRippler(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXRippler] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxJFXRippler(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXRippler] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun NodeManager.styledJFXRippler(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxJFXRippler(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

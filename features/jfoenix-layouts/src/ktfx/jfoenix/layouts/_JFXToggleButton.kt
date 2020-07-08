@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXToggleButton
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.ToggleButtonManager
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [JFXToggleButton] to this manager.
 */
fun NodeManager.jfxToggleButton(): JFXToggleButton = jfxToggleButton() { }

/**
 * Add a [JFXToggleButton] to this manager.
 */
fun ToggleButtonManager.jfxToggleButton(): JFXToggleButton = jfxToggleButton() { }

/**
 * Create a [JFXToggleButton] with configuration block.
 */
inline fun jfxToggleButton(configuration: (@LayoutDslMarker JFXToggleButton).() -> Unit):
    JFXToggleButton {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(JFXToggleButton(), configuration = configuration)
    }

/**
 * Add a [JFXToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.jfxToggleButton(
    configuration: (@LayoutDslMarker JFXToggleButton).() ->
    Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXToggleButton(), configuration = configuration))
}

/**
 * Add a [JFXToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.jfxToggleButton(
    configuration: (
        @LayoutDslMarker
        JFXToggleButton
    ).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXToggleButton(), configuration = configuration))
}

/**
 * Create a styled [JFXToggleButton].
 */
fun styledJFXToggleButton(vararg styleClass: String, id: String? = null): JFXToggleButton =
    styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleButton] to this manager.
 */
fun NodeManager.styledJFXToggleButton(vararg styleClass: String, id: String? = null):
    JFXToggleButton = styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXToggleButton] to this manager.
 */
fun ToggleButtonManager.styledJFXToggleButton(vararg styleClass: String, id: String? = null):
    JFXToggleButton = styledJFXToggleButton(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXToggleButton] with configuration block.
 */
inline fun styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXToggleButton(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXToggleButton] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXToggleButton(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

/**
 * Add a styled [JFXToggleButton] with configuration block to this manager.
 */
inline fun ToggleButtonManager.styledJFXToggleButton(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXToggleButton).() -> Unit
): JFXToggleButton {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXToggleButton(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

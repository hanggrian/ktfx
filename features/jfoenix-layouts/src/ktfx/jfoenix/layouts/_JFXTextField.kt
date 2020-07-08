@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXTextField
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
 * Add a [JFXTextField] to this manager.
 */
fun NodeManager.jfxTextField(text: String? = null): JFXTextField = jfxTextField(text = text) { }

/**
 * Create a [JFXTextField] with configuration block.
 */
inline fun jfxTextField(
    text: String? = null,
    configuration: (@LayoutDslMarker JFXTextField).() ->    
    Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(JFXTextField(text), configuration = configuration)
}

/**
 * Add a [JFXTextField] with configuration block to this manager.
 */
inline fun NodeManager.jfxTextField(
    text: String? = null,
    configuration: (
        @LayoutDslMarker    
        JFXTextField
    ).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(JFXTextField(text), configuration = configuration))
}

/**
 * Create a styled [JFXTextField].
 */
fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [JFXTextField] to this manager.
 */
fun NodeManager.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null
): JFXTextField = styledJFXTextField(text = text, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [JFXTextField] with configuration block.
 */
inline fun styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        JFXTextField(text), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [JFXTextField] with configuration block to this manager.
 */
inline fun NodeManager.styledJFXTextField(
    text: String? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker JFXTextField).() -> Unit
): JFXTextField {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            JFXTextField(text), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

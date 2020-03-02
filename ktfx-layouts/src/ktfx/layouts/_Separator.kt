@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Separator
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [Separator] to this manager.
 */
fun NodeManager.separator(): Separator = separator() { }

/**
 * Create a [Separator] with configuration block.
 */
inline fun separator(configuration: (@LayoutDslMarker Separator).() -> Unit): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Separator(), configuration = configuration)
}

/**
 * Add a [Separator] with configuration block to this manager.
 */
inline fun NodeManager.separator(configuration: (@LayoutDslMarker Separator).() -> Unit):
        Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Separator(), configuration = configuration))
}

/**
 * Create a styled [Separator].
 */
fun styledSeparator(vararg styleClass: String): Separator = styledSeparator(styleClass =
        *styleClass) { }

/**
 * Add a styled [Separator] to this manager.
 */
fun NodeManager.styledSeparator(vararg styleClass: String): Separator = styledSeparator(styleClass =
        *styleClass) { }

/**
 * Create a styled [Separator] with configuration block.
 */
inline fun styledSeparator(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(Separator(), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [Separator] with configuration block to this manager.
 */
inline fun NodeManager.styledSeparator(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(Separator(), styleClass = *styleClass, configuration = configuration))
}

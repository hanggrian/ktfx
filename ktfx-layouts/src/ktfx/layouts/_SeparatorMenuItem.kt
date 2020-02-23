@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Create a styled [SeparatorMenuItem].
 */
fun styledSeparatorMenuItem(vararg styleClass: String): SeparatorMenuItem =
        styledSeparatorMenuItem(styleClass = *styleClass) { }

/**
 * Add a styled [SeparatorMenuItem] to this manager.
 */
fun MenuItemManager.styledSeparatorMenuItem(vararg styleClass: String): SeparatorMenuItem =
        styledSeparatorMenuItem(styleClass = *styleClass) { }

/**
 * Create a styled [SeparatorMenuItem] with configuration block.
 */
inline fun styledSeparatorMenuItem(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker    
            SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(SeparatorMenuItem(), styleClass = *styleClass, configuration = configuration)
}

/**
 * Add a styled [SeparatorMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.styledSeparatorMenuItem(
    vararg styleClass: String,
    configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(SeparatorMenuItem(), styleClass = *styleClass, configuration =
            configuration))
}

/**
 * Add a [SeparatorMenuItem] to this manager.
 */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem = separatorMenuItem() { }

/**
 * Create a [SeparatorMenuItem] with configuration block.
 */
inline fun separatorMenuItem(configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit):
        SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(SeparatorMenuItem(), configuration = configuration)
}

/**
 * Add a [SeparatorMenuItem] with configuration block to this manager.
 */
inline fun MenuItemManager.separatorMenuItem(
    configuration: (@LayoutDslMarker
SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(SeparatorMenuItem(), configuration = configuration))
}

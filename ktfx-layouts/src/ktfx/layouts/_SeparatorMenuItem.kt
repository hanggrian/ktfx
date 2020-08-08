@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.SeparatorMenuItem
import ktfx.internal.KtfxInternals.newChild
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SeparatorMenuItem] to this manager.
 *
 * @return the control added.
 */
fun MenuItemManager.separatorMenuItem(): SeparatorMenuItem = separatorMenuItem() { }

/**
 * Create a [SeparatorMenuItem] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
inline fun separatorMenuItem(configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit):
    SeparatorMenuItem {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(SeparatorMenuItem(), configuration = configuration)
    }

/**
 * Add a [SeparatorMenuItem] with configuration block to this manager.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
inline fun MenuItemManager.separatorMenuItem(
    configuration: (
        @LayoutDslMarker
        SeparatorMenuItem
    ).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(SeparatorMenuItem(), configuration = configuration))
}

/**
 * Create a styled [SeparatorMenuItem].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
fun styledSeparatorMenuItem(vararg styleClass: String, id: String? = null): SeparatorMenuItem =
    styledSeparatorMenuItem(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SeparatorMenuItem] to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
fun MenuItemManager.styledSeparatorMenuItem(vararg styleClass: String, id: String? = null):
    SeparatorMenuItem = styledSeparatorMenuItem(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SeparatorMenuItem] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
inline fun styledSeparatorMenuItem(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        SeparatorMenuItem(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [SeparatorMenuItem] with configuration block to this manager.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
inline fun MenuItemManager.styledSeparatorMenuItem(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker SeparatorMenuItem).() -> Unit
): SeparatorMenuItem {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            SeparatorMenuItem(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

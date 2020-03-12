@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.PrefixSelectionComboBox

/**
 * Add a [PrefixSelectionComboBox] to this manager.
 */
fun <T> NodeManager.prefixSelectionComboBox(): PrefixSelectionComboBox<T> =
        prefixSelectionComboBox() { }

/**
 * Create a [PrefixSelectionComboBox] with configuration block.
 */
inline fun <T> prefixSelectionComboBox(
    configuration: (@LayoutDslMarker
PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PrefixSelectionComboBox<T>(), configuration = configuration)
}

/**
 * Add a [PrefixSelectionComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.prefixSelectionComboBox(
    configuration: (@LayoutDslMarker
PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PrefixSelectionComboBox<T>(), configuration = configuration))
}

/**
 * Create a styled [PrefixSelectionComboBox].
 */
fun <T> styledPrefixSelectionComboBox(vararg styleClass: String, id: String? = null):
        PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [PrefixSelectionComboBox] to this manager.
 */
fun <T> NodeManager.styledPrefixSelectionComboBox(vararg styleClass: String, id: String? = null):
        PrefixSelectionComboBox<T> = styledPrefixSelectionComboBox(styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [PrefixSelectionComboBox] with configuration block.
 */
inline fun <T> styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PrefixSelectionComboBox<T>(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [PrefixSelectionComboBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledPrefixSelectionComboBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionComboBox<T>).() -> Unit
): PrefixSelectionComboBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PrefixSelectionComboBox<T>(), styleClass = *styleClass, id = id,
            configuration = configuration))
}

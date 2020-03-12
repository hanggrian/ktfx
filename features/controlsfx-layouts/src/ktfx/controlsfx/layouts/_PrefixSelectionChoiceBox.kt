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
import org.controlsfx.control.PrefixSelectionChoiceBox

/**
 * Add a [PrefixSelectionChoiceBox] to this manager.
 */
fun <T> NodeManager.prefixSelectionChoiceBox(): PrefixSelectionChoiceBox<T> =
        prefixSelectionChoiceBox() { }

/**
 * Create a [PrefixSelectionChoiceBox] with configuration block.
 */
inline fun <T> prefixSelectionChoiceBox(
    configuration: (@LayoutDslMarker
PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PrefixSelectionChoiceBox<T>(), configuration = configuration)
}

/**
 * Add a [PrefixSelectionChoiceBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.prefixSelectionChoiceBox(
    configuration: (@LayoutDslMarker
PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PrefixSelectionChoiceBox<T>(), configuration = configuration))
}

/**
 * Create a styled [PrefixSelectionChoiceBox].
 */
fun <T> styledPrefixSelectionChoiceBox(vararg styleClass: String, id: String? = null):
        PrefixSelectionChoiceBox<T> = styledPrefixSelectionChoiceBox(styleClass = *styleClass, id =
        id) { }

/**
 * Add a styled [PrefixSelectionChoiceBox] to this manager.
 */
fun <T> NodeManager.styledPrefixSelectionChoiceBox(vararg styleClass: String, id: String? = null):
        PrefixSelectionChoiceBox<T> = styledPrefixSelectionChoiceBox(styleClass = *styleClass, id =
        id) { }

/**
 * Create a styled [PrefixSelectionChoiceBox] with configuration block.
 */
inline fun <T> styledPrefixSelectionChoiceBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(PrefixSelectionChoiceBox<T>(), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [PrefixSelectionChoiceBox] with configuration block to this manager.
 */
inline fun <T> NodeManager.styledPrefixSelectionChoiceBox(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker PrefixSelectionChoiceBox<T>).() -> Unit
): PrefixSelectionChoiceBox<T> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(PrefixSelectionChoiceBox<T>(), styleClass = *styleClass, id = id,
            configuration = configuration))
}

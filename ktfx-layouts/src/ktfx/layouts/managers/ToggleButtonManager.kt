@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.ToggleButton
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [ToggleButton].
 * Used for `SegmentedButton.kt`.
 */
interface ToggleButtonManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param button child to add
     * @return the child added
     */
    fun <T : ToggleButton> addButton(button: T): T
}

/** Alias of [ToggleButtonManager.addButton] with [init] builder. */
inline fun <T : ToggleButton> ToggleButtonManager.addButton(button: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    button.init()
    return addButton(button)
}

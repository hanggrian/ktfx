@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:Suppress("PackageDirectoryMismatch")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.TitledPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [TitledPane].
 *
 * @see javafx.scene.control.Accordion
 */
interface TitledPaneManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param pane child to add
     * @return the child added
     */
    fun <T : TitledPane> addPane(pane: T): T
}

/** Alias of [addPane] with [init] builder. */
inline fun <T : TitledPane> TitledPaneManager.addPane(pane: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    pane.init()
    return addPane(pane)
}

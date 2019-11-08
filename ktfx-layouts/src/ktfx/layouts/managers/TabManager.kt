@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Tab
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [Tab].
 * Also being used in `JFXTabPane.kt`.
 *
 * @see javafx.scene.control.TabPane
 */
interface TabManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param tab child to add
     * @return the child added
     */
    fun <T : Tab> addTab(tab: T): T
}

/** Alias of [TabManager.addTab] with [init] builder. */
inline fun <T : Tab> TabManager.addTab(tab: T, init: T.() -> Unit): T {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    tab.init()
    return addTab(tab)
}

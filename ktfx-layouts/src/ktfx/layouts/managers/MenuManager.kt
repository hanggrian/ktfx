@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Menu
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [Menu].
 *
 * @see javafx.scene.control.MenuBar
 */
interface MenuManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param menu child to add
     * @return the child added
     */
    fun <T : Menu> addMenu(menu: T): T
}

/** Alias of [MenuManager.addMenu] with [init] builder. */
inline fun <T : Menu> MenuManager.addMenu(menu: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    menu.init()
    return addMenu(menu)
}

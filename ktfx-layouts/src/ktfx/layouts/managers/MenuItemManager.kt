@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:Suppress("PackageDirectoryMismatch")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.MenuItem
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [MenuItem].
 *
 * @see javafx.scene.control.ContextMenu
 * @see javafx.scene.control.Menu
 * @see javafx.scene.control.MenuButton
 * @see javafx.scene.control.SplitMenuButton
 */
interface MenuItemManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param item child to add
     * @return the child added
     */
    fun <T : MenuItem> addItem(item: T): T
}

/** Alias of [addItem] with [init] builder. */
inline fun <T : MenuItem> MenuItemManager.addItem(item: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    item.init()
    return addItem(item)
}

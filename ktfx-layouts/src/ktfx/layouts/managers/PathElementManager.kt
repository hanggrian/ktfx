@file:JvmMultifileClass
@file:JvmName("ManagerKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.PathElement
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Container of [PathElement].
 *
 * @see javafx.scene.shape.Path
 */
interface PathElementManager {

    /**
     * Allows child to be added dynamically with Kotlin DSL in the context of this manager.
     *
     * @param element child to add
     * @return the child added
     */
    fun <T : PathElement> addElement(element: T): T
}

/** Alias of [PathElementManager.addElement] with [init] builder. */
inline fun <T : PathElement> PathElementManager.addElement(element: T, init: (@LayoutDslMarker T).() -> Unit): T {
    contract {
        callsInPlace(init, InvocationKind.EXACTLY_ONCE)
    }
    element.init()
    return addElement(element)
}

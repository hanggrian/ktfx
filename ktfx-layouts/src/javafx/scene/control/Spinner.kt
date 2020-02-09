@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Spinner
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Spinner] with configurationialization block. */
inline fun <T> spinner(
    configuration: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Spinner<T>().apply(configuration)
}

/** Add a [Spinner] to this manager. */
fun <T> NodeManager.spinner(): Spinner<T> = addChild(Spinner())

/** Add a [Spinner] with configurationialization block to this manager. */
inline fun <T> NodeManager.spinner(
    configuration: (@LayoutDslMarker Spinner<T>).() -> Unit
): Spinner<T> {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Spinner(), configuration)
}

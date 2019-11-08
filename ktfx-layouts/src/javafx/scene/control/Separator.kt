@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.control.Separator
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Separator] with initialization block. */
inline fun separator(
    init: Separator.() -> Unit
): Separator {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return Separator().apply(init)
}

/** Add a [Separator] to this manager. */
fun NodeManager.separator(): Separator =
    addNode(Separator())

/** Add a [Separator] with initialization block to this manager. */
inline fun NodeManager.separator(
    init: Separator.() -> Unit
): Separator {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(Separator(), init)
}

/** Create a vertical [Separator] with initialization block. */
inline fun verticalSeparator(
    init: Separator.() -> Unit
): Separator = separator {
    orientation = Orientation.VERTICAL
    init()
}

/** Add a vertical [Separator] to this manager. */
@Suppress("NOTHING_TO_INLINE")
inline fun NodeManager.verticalSeparator(): Separator =
    addNode(Separator(Orientation.VERTICAL))

/** Add a vertical [Separator] with initialization block to this manager. */
inline fun NodeManager.verticalSeparator(
    init: Separator.() -> Unit
): Separator = separator {
    orientation = Orientation.VERTICAL
    init()
}

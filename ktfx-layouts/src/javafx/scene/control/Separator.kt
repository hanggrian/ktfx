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
    configuration: (@LayoutsDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Separator().apply(configuration)
}

/** Add a [Separator] to this manager. */
fun NodeManager.separator(): Separator = addChild(Separator())

/** Add a [Separator] with initialization block to this manager. */
inline fun NodeManager.separator(
    configuration: (@LayoutsDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Separator(), configuration)
}

/** Create a vertical [Separator] with initialization block. */
inline fun verticalSeparator(
    configuration: (@LayoutsDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return separator {
        orientation = Orientation.VERTICAL
        configuration()
    }
}

/** Add a vertical [Separator] to this manager. */
@Suppress("NOTHING_TO_INLINE")
inline fun NodeManager.verticalSeparator(): Separator = separator { Orientation.VERTICAL }

/** Add a vertical [Separator] with initialization block to this manager. */
inline fun NodeManager.verticalSeparator(
    configuration: (@LayoutsDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return separator {
        orientation = Orientation.VERTICAL
        configuration()
    }
}

@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.geometry.Orientation
import javafx.scene.control.Separator
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

inline fun verticalSeparator(
    configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return separator {
        orientation = Orientation.VERTICAL
        configuration()
    }
}

fun NodeManager.verticalSeparator(): Separator = separator { Orientation.VERTICAL }

inline fun NodeManager.verticalSeparator(
    configuration: (@LayoutDslMarker Separator).() -> Unit
): Separator {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return separator {
        orientation = Orientation.VERTICAL
        configuration()
    }
}

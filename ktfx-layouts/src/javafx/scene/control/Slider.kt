@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.control.Slider
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [Slider] with configuration block. */
inline fun slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return Slider(min, max, value).apply(configuration)
}

/** Add a [Slider] to this manager. */
fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0
): Slider = addChild(Slider(min, max, value))

/** Add a [Slider] with configuration block to this manager. */
inline fun NodeManager.slider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 0.0,
    configuration: (@LayoutDslMarker Slider).() -> Unit
): Slider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(Slider(min, max, value), configuration)
}

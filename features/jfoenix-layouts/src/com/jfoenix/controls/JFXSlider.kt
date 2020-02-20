@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXSlider
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/** Create a [JFXSlider] with configuration block. */
inline fun jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return JFXSlider(min, max, value).apply(configuration)
}

/** Add a [JFXSlider] to this manager. */
fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0
): JFXSlider = addChild(JFXSlider(min, max, value))

/** Add a [JFXSlider] with configuration block to this manager. */
inline fun NodeManager.jfxSlider(
    min: Double = 0.0,
    max: Double = 100.0,
    value: Double = 50.0,
    configuration: (@LayoutDslMarker JFXSlider).() -> Unit
): JFXSlider {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(JFXSlider(min, max, value), configuration)
}

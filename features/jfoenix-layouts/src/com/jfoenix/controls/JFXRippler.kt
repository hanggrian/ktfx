@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXRippler] with dynamic-layout dsl support.
 * Invoking dsl will only set its children.
 */
open class KtfxJFXRippler : JFXRippler(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { control = it }

    final override val childCount: Int get() = if (control != null) 1 else 0
}

/** Create a [JFXRippler] with initialization block. */
inline fun jfxRippler(
    init: (@LayoutsDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXRippler().apply(init)
}

/** Add a [JFXRippler] to this manager. */
fun NodeManager.jfxRippler(): JFXRippler =
    addChild(KtfxJFXRippler())

/** Add a [JFXRippler] with initialization block to this manager. */
inline fun NodeManager.jfxRippler(
    init: (@LayoutsDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXRippler(), init)
}

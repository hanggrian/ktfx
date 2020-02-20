@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXRippler
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXRippler] with dynamic-layout dsl support.
 * Invoking dsl will only set its children.
 */
open class KtfxJFXRippler : JFXRippler(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}

/** Create a [JFXRippler] with configuration block. */
inline fun jfxRippler(
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXRippler().apply(configuration)
}

/** Add a [JFXRippler] to this manager. */
fun NodeManager.jfxRippler(): JFXRippler =
    addChild(KtfxJFXRippler())

/** Add a [JFXRippler] with configuration block to this manager. */
inline fun NodeManager.jfxRippler(
    configuration: (@LayoutDslMarker KtfxJFXRippler).() -> Unit
): JFXRippler {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXRippler(), configuration)
}

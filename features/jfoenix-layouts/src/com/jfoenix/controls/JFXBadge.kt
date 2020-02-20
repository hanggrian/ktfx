@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXBadge
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXBadge] with dynamic-layout dsl support.
 * Invoking dsl will only set its control.
 */
open class KtfxJFXBadge : JFXBadge(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { control = it }
}

/** Create a [JFXBadge] with configuration block. */
inline fun jfxBadge(
    configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXBadge().apply(configuration)
}

/** Add a [JFXBadge] to this manager. */
fun NodeManager.jfxBadge(): JFXBadge = addChild(KtfxJFXBadge())

/** Add a [JFXBadge] with configuration block to this manager. */
inline fun NodeManager.jfxBadge(
    configuration: (@LayoutDslMarker KtfxJFXBadge).() -> Unit
): JFXBadge {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXBadge(), configuration)
}

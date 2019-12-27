@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXDrawer] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXDrawer : JFXDrawer(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content += it }

    final override val childCount: Int get() = if (content != null) 1 else 0
}

/** Create a [JFXDrawer] with initialization block. */
inline fun jfxDrawer(
    configuration: (@LayoutsDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXDrawer().apply(configuration)
}

/** Add a [JFXDrawer] to this manager. */
fun NodeManager.jfxDrawer(): JFXDrawer = addChild(JFXDrawer())

/** Add a [JFXDrawer] with initialization block to this manager. */
inline fun NodeManager.jfxDrawer(
    configuration: (@LayoutsDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXDrawer(), configuration)
}

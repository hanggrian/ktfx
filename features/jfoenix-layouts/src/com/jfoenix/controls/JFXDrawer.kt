@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXDrawer
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXDrawer] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXDrawer : JFXDrawer(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { content += it }
}

/** Create a [JFXDrawer] with configuration block. */
inline fun jfxDrawer(
    configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXDrawer().apply(configuration)
}

/** Add a [JFXDrawer] to this manager. */
fun NodeManager.jfxDrawer(): JFXDrawer = addChild(JFXDrawer())

/** Add a [JFXDrawer] with configuration block to this manager. */
inline fun NodeManager.jfxDrawer(
    configuration: (@LayoutDslMarker KtfxJFXDrawer).() -> Unit
): JFXDrawer {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXDrawer(), configuration)
}

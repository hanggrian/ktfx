@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXClippedPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXClippedPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXClippedPane : JFXClippedPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size
}

/** Create a [JFXClippedPane] with initialization block. */
inline fun jfxClippedPane(
    configuration: (@LayoutsDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXClippedPane().apply(configuration)
}

/** Add a [JFXClippedPane] to this manager. */
fun NodeManager.jfxClippedPane(): JFXClippedPane = addChild(KtfxJFXClippedPane())

/** Add a [JFXClippedPane] with initialization block to this manager. */
inline fun NodeManager.jfxClippedPane(
    configuration: (@LayoutsDslMarker KtfxJFXClippedPane).() -> Unit
): JFXClippedPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXClippedPane(), configuration)
}

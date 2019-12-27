@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXNodesList
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXNodesList] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXNodesList : JFXNodesList(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size
}

/** Create a [JFXNodesList] with initialization block. */
inline fun jfxNodesList(
    configuration: (@LayoutsDslMarker KtfxJFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXNodesList().apply(configuration)
}

/** Add a [JFXNodesList] to this manager. */
fun NodeManager.jfxNodesList(): JFXNodesList =
    addChild(JFXNodesList())

/** Add a [JFXNodesList] with initialization block to this manager. */
inline fun NodeManager.jfxNodesList(
    configuration: (@LayoutsDslMarker KtfxJFXNodesList).() -> Unit
): JFXNodesList {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXNodesList(), configuration)
}

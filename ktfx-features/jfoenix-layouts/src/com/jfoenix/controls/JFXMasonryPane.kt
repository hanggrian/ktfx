@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild

/**
 * [JFXMasonryPane] with dynamic-layout dsl support.
 * Invoking dsl will add its children.
 */
open class KtfxJFXMasonryPane : JFXMasonryPane(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { children += it }

    final override val childCount: Int get() = childrenUnmodifiable.size
}

/** Create a [JFXMasonryPane] with initialization block. */
inline fun jfxMasonryPane(
    init: (@LayoutsDslMarker KtfxJFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxJFXMasonryPane().apply(init)
}

/** Add a [JFXMasonryPane] to this manager. */
fun NodeManager.jfxMasonryPane(): JFXMasonryPane = addChild(JFXMasonryPane())

/** Add a [JFXMasonryPane] with initialization block to this manager. */
inline fun NodeManager.jfxMasonryPane(
    init: (@LayoutsDslMarker KtfxJFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxJFXMasonryPane(), init)
}

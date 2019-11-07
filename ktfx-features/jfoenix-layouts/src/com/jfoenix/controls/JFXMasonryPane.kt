@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.jfoenix.layouts

import com.jfoenix.controls.JFXMasonryPane
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXMasonryPane] with initialization block. */
inline fun jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return JFXMasonryPane().apply(init)
}
/** Add a [JFXMasonryPane] to this manager. */
fun NodeManager.jfxMasonryPane(): JFXMasonryPane =
    addNode(JFXMasonryPane())

/** Add a [JFXMasonryPane] with initialization block to this manager. */
inline fun NodeManager.jfxMasonryPane(
    init: (@LayoutDslMarker JFXMasonryPane).() -> Unit
): JFXMasonryPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(JFXMasonryPane(), init)
}

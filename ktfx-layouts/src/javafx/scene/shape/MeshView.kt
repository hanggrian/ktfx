@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MeshView] with initialization block. */
inline fun meshView(
    mesh: Mesh? = null,
    init: (@LayoutsDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return MeshView(mesh).apply(init)
}

/** Add a [MeshView] to this manager. */
fun NodeManager.meshView(
    mesh: Mesh? = null
): MeshView = addChild(MeshView(mesh))

/** Add a [MeshView] with initialization block to this manager. */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    init: (@LayoutsDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addChild(MeshView(mesh), init)
}

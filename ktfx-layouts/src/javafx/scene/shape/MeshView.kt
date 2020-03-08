@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [MeshView] with configuration block. */
inline fun meshView(
    mesh: Mesh? = null,
    configuration: (@LayoutDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return MeshView(mesh).apply(configuration)
}

/** Add a [MeshView] to this manager. */
fun NodeManager.meshView(
    mesh: Mesh? = null
): MeshView = addChild(MeshView(mesh))

/** Add a [MeshView] with configuration block to this manager. */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    configuration: (@LayoutDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(MeshView(mesh), configuration)
}

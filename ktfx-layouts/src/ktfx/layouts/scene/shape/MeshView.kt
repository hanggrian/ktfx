@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

/** Creates a [MeshView]. */
fun meshView(
    mesh: Mesh? = null,
    init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = MeshView(mesh).also {
    init?.invoke(it)
}

/** Creates a [MeshView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.meshView(
    mesh: Mesh? = null,
    noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = ktfx.layouts.meshView(mesh, init).add()

/** Create a styled [MeshView]. */
fun styledMeshView(
    styleClass: String,
    mesh: Mesh? = null,
    init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = MeshView(mesh).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MeshView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMeshView(
    styleClass: String,
    mesh: Mesh? = null,
    noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = ktfx.layouts.styledMeshView(styleClass, mesh, init).add()
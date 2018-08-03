@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

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
): MeshView = javafxx.layouts.meshView(mesh, init)()

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
): MeshView = javafxx.layouts.styledMeshView(styleClass, mesh, init)()
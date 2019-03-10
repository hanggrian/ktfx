@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

/** Creates a [MeshView]. */
fun meshView(
    mesh: Mesh? = null,
    init: ((@LayoutMarker MeshView).() -> Unit)? = null
): MeshView = MeshView(mesh).also { init?.invoke(it) }

/** Creates a [MeshView] and add it to this manager. */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    noinline init: ((@LayoutMarker MeshView).() -> Unit)? = null
): MeshView = ktfx.layouts.meshView(mesh, init).add()
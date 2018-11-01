@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import ktfx.NodeManager
import ktfx.LayoutDsl

/** Creates a [MeshView]. */
fun meshView(
    mesh: Mesh? = null,
    init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = MeshView(mesh).also { init?.invoke(it) }

/** Creates a [MeshView] and add it to this manager. */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null
): MeshView = ktfx.layouts.meshView(mesh, init)()
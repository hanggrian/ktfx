@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

/** Add a [MeshView] to this manager. */
fun NodeManager.meshView(
    mesh: Mesh? = null
): MeshView = MeshView(mesh).add()

/** Add a [MeshView] with initialization block to this manager. */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    init: (@LayoutDslMarker MeshView).() -> Unit
): MeshView = meshView(mesh).apply(init)

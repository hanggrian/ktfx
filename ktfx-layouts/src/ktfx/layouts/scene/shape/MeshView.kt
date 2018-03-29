@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

inline fun meshView(
    mesh: Mesh? = null
): MeshView = meshView(mesh) { }

inline fun meshView(
    mesh: Mesh? = null,
    init: (@LayoutDsl MeshView).() -> Unit
): MeshView = MeshView(mesh).apply(init)

inline fun LayoutManager<Node>.meshView(
    mesh: Mesh? = null
): MeshView = meshView(mesh) { }

inline fun LayoutManager<Node>.meshView(
    mesh: Mesh? = null,
    init: (@LayoutDsl MeshView).() -> Unit
): MeshView = ktfx.layouts.meshView(mesh, init).add()
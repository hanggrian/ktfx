@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

inline fun meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }

inline fun Manager<Node>.meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = ktfx.layouts.meshView(mesh, init).add()
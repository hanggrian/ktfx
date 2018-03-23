@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView

inline fun meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = MeshView(mesh).apply { init?.invoke(this) }
inline fun ChildManager.meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = ktfx.layouts.meshView(mesh, init).add()
inline fun ItemManager.meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = ktfx.layouts.meshView(mesh, init).add()
inline fun ButtonManager.meshView(mesh: Mesh? = null, noinline init: ((@LayoutDsl MeshView).() -> Unit)? = null): MeshView = ktfx.layouts.meshView(mesh, init).add()
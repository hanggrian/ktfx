@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [MeshView] to this manager.
 */
fun NodeManager.meshView(mesh: Mesh? = null): MeshView = meshView(mesh = mesh) { }

/**
 * Create a [MeshView] with configuration block.
 */
inline fun meshView(mesh: Mesh? = null, configuration: (@LayoutDslMarker MeshView).() -> Unit):
        MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MeshView(mesh), configuration = configuration)
}

/**
 * Add a [MeshView] with configuration block to this manager.
 */
inline fun NodeManager.meshView(
    mesh: Mesh? = null,
    configuration: (@LayoutDslMarker MeshView).() ->    
            Unit
): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MeshView(mesh), configuration = configuration))
}

/**
 * Create a styled [MeshView].
 */
fun styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null
): MeshView = styledMeshView(mesh = mesh, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MeshView] to this manager.
 */
fun NodeManager.styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null
): MeshView = styledMeshView(mesh = mesh, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MeshView] with configuration block.
 */
inline fun styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(MeshView(mesh), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [MeshView] with configuration block to this manager.
 */
inline fun NodeManager.styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker MeshView).() -> Unit
): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(MeshView(mesh), styleClass = *styleClass, id = id, configuration =
            configuration))
}

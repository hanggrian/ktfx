@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.scene.shape.Mesh
import javafx.scene.shape.MeshView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [MeshView] to this container.
 *
 * @return the control added.
 */
public fun NodeContainer.meshView(mesh: Mesh? = null): MeshView = meshView(mesh = mesh) { }

/**
 * Create a [MeshView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun meshView(mesh: Mesh? = null, configuration: (@KtfxLayoutDslMarker
        MeshView).() -> Unit): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MeshView(mesh)
    child.configuration()
    return child
}

/**
 * Add a [MeshView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun NodeContainer.meshView(mesh: Mesh? = null, configuration: (@KtfxLayoutDslMarker
        MeshView).() -> Unit): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MeshView(mesh)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [MeshView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
): MeshView = styledMeshView(mesh = mesh, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [MeshView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun NodeContainer.styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
): MeshView = styledMeshView(mesh = mesh, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [MeshView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MeshView).() -> Unit,
): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MeshView(mesh)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [MeshView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun NodeContainer.styledMeshView(
    mesh: Mesh? = null,
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker MeshView).() -> Unit,
): MeshView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = MeshView(mesh)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

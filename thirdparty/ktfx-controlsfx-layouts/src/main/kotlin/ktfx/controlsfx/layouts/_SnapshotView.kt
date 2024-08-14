@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.controlsfx.layouts

import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.layouts.KtfxLayoutDslMarker
import ktfx.layouts.NodeContainer
import org.controlsfx.control.SnapshotView

/**
 * Add a [SnapshotView] to this container.
 *
 * @return the control added.
 */
public inline fun NodeContainer.snapshotView(): SnapshotView = snapshotView() { }

/**
 * Create a [SnapshotView] with configuration block.
 *
 * @param configuration the configuration block.
 * @return the control created.
 */
public fun snapshotView(configuration: (@KtfxLayoutDslMarker KtfxSnapshotView).() -> Unit):
        SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSnapshotView()
    child.configuration()
    return child
}

/**
 * Add a [SnapshotView] with configuration block to this container.
 *
 * @param configuration the configuration block.
 * @return the control added.
 */
public fun NodeContainer.snapshotView(configuration: (@KtfxLayoutDslMarker
        KtfxSnapshotView).() -> Unit): SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSnapshotView()
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [SnapshotView].
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control created.
 */
public inline fun styledSnapshotView(vararg styleClass: String, id: String? = null): SnapshotView =
        styledSnapshotView(styleClass = styleClass, id = id) { }

/**
 * Add a styled [SnapshotView] to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @return the styled control added.
 */
public inline fun NodeContainer.styledSnapshotView(vararg styleClass: String, id: String? = null):
        SnapshotView = styledSnapshotView(styleClass = styleClass, id = id) { }

/**
 * Create a styled [SnapshotView] with configuration block.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control created.
 */
public fun styledSnapshotView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSnapshotView).() -> Unit,
): SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSnapshotView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [SnapshotView] with configuration block to this container.
 *
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 * @return the styled control added.
 */
public fun NodeContainer.styledSnapshotView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker KtfxSnapshotView).() -> Unit,
): SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = KtfxSnapshotView()
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}

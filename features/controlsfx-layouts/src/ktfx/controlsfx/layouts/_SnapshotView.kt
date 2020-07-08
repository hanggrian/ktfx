@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import ktfx.internal.KtfxInternals.newChild
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [SnapshotView] to this manager.
 */
fun NodeManager.snapshotView(): SnapshotView = snapshotView() { }

/**
 * Create a [SnapshotView] with configuration block.
 */
inline fun snapshotView(configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit):
    SnapshotView {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return newChild(KtfxSnapshotView(), configuration = configuration)
    }

/**
 * Add a [SnapshotView] with configuration block to this manager.
 */
inline fun NodeManager.snapshotView(configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit):
    SnapshotView {
        contract { callsInPlace(configuration, EXACTLY_ONCE) }
        return addChild(newChild(KtfxSnapshotView(), configuration = configuration))
    }

/**
 * Create a styled [SnapshotView].
 */
fun styledSnapshotView(vararg styleClass: String, id: String? = null): SnapshotView =
    styledSnapshotView(styleClass = *styleClass, id = id) { }

/**
 * Add a styled [SnapshotView] to this manager.
 */
fun NodeManager.styledSnapshotView(vararg styleClass: String, id: String? = null): SnapshotView =
    styledSnapshotView(styleClass = *styleClass, id = id) { }

/**
 * Create a styled [SnapshotView] with configuration block.
 */
inline fun styledSnapshotView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(
        KtfxSnapshotView(), styleClass = *styleClass, id = id,
        configuration =
            configuration
    )
}

/**
 * Add a styled [SnapshotView] with configuration block to this manager.
 */
inline fun NodeManager.styledSnapshotView(
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(
        newChild(
            KtfxSnapshotView(), styleClass = *styleClass, id = id,
            configuration =
                configuration
        )
    )
}

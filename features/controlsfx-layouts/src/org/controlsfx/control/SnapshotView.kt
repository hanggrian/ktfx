@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.SnapshotView

/**
 * [SnapshotView] with dynamic-layout dsl support.
 * Invoking dsl will only set its node.
 */
open class KtfxSnapshotView : SnapshotView(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { this.node = it }

    final override val childCount: Int get() = if (node != null) 1 else 0
}

/** Create a [SnapshotView] with initialization block. */
inline fun snapshotView(
    configuration: (@LayoutsDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSnapshotView().apply(configuration)
}

/** Add a [SnapshotView] to this manager. */
fun NodeManager.snapshotView(): SnapshotView = addChild(KtfxSnapshotView())

/** Add a [SnapshotView] with initialization block to this manager. */
inline fun NodeManager.snapshotView(
    configuration: (@LayoutsDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSnapshotView(), configuration)
}

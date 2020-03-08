@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.SnapshotView

/**
 * [SnapshotView] with dynamic-layout dsl support.
 * Invoking dsl will only set its node.
 */
open class KtfxSnapshotView : SnapshotView(), NodeManager {

    final override fun <C : Node> addChild(child: C): C = child.also { this.node = it }
}

/** Create a [SnapshotView] with configuration block. */
inline fun snapshotView(
    configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxSnapshotView().apply(configuration)
}

/** Add a [SnapshotView] to this manager. */
fun NodeManager.snapshotView(): SnapshotView = addChild(KtfxSnapshotView())

/** Add a [SnapshotView] with configuration block to this manager. */
inline fun NodeManager.snapshotView(
    configuration: (@LayoutDslMarker KtfxSnapshotView).() -> Unit
): SnapshotView {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxSnapshotView(), configuration)
}

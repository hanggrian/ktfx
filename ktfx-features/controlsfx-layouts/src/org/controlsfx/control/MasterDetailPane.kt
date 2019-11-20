@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.KtfxLayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.MasterDetailPane

/**
 * [MasterDetailPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its master and detail, in order.
 */
open class KtfxMasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {
    private var size = 0

    final override fun <T : Node> addNode(node: T): T =
        node.also {
            when (size++) {
                0 -> masterNode = it
                1 -> detailNode = it
                else -> error("Master and detail node has been set.")
            }
        }
}

/** Create a [MasterDetailPane] with initialization block. */
inline fun masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@KtfxLayoutsDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxMasterDetailPane(side, showDetail).apply(init)
}

/** Add a [MasterDetailPane] to this manager. */
fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true
): MasterDetailPane = addNode(KtfxMasterDetailPane(side, showDetail))

/** Add a [MasterDetailPane] with initialization block to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@KtfxLayoutsDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxMasterDetailPane(side, showDetail), init)
}

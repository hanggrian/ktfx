@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.LayoutsDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addChild
import org.controlsfx.control.MasterDetailPane

/**
 * [MasterDetailPane] with dynamic-layout dsl support.
 * Invoking dsl will only set its master and detail, in order.
 */
open class KtfxMasterDetailPane(detailSide: Side, showDetail: Boolean) :
    MasterDetailPane(detailSide, showDetail), NodeManager {
    private var size = 0

    final override fun <C : Node> addChild(child: C): C =
        child.also {
            when (size++) {
                0 -> masterNode = it
                1 -> detailNode = it
                else -> error("Master and detail node has been set.")
            }
        }

    final override val childCount: Int get() = size
}

/** Create a [MasterDetailPane] with initialization block. */
inline fun masterDetailPane(
    detailSide: Side = Side.RIGHT,
    showDetailNode: Boolean = true,
    configuration: (@LayoutsDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return KtfxMasterDetailPane(detailSide, showDetailNode).apply(configuration)
}

/** Add a [MasterDetailPane] to this manager. */
fun NodeManager.masterDetailPane(
    detailSide: Side = Side.RIGHT,
    showDetailNode: Boolean = true
): MasterDetailPane = addChild(KtfxMasterDetailPane(detailSide, showDetailNode))

/** Add a [MasterDetailPane] with initialization block to this manager. */
inline fun NodeManager.masterDetailPane(
    detailSide: Side = Side.RIGHT,
    showDetailNode: Boolean = true,
    configuration: (@LayoutsDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    return addChild(KtfxMasterDetailPane(detailSide, showDetailNode), configuration)
}

@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.NodeManager
import org.controlsfx.control.MasterDetailPane
import kotlin.contracts.ExperimentalContracts

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
}

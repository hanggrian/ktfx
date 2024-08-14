@file:JvmMultifileClass
@file:JvmName("ControlsfxLayoutsKt")

package ktfx.controlsfx.layouts

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.NodeContainer
import org.controlsfx.control.MasterDetailPane

/**
 * [MasterDetailPane] with dynamic-layout dsl support. Invoking dsl will only set its master and
 * detail, in order.
 */
public open class KtfxMasterDetailPane(detailSide: Side, showDetail: Boolean) :
    MasterDetailPane(detailSide, showDetail),
    NodeContainer {
    private var size = 0

    final override fun <T : Node> addChild(child: T): T =
        child.also {
            when (size++) {
                0 -> masterNode = it
                1 -> detailNode = it
                else -> error("Master and detail node has been set.")
            }
        }
}

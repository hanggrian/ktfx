@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MasterDetailPane

open class KtfxMasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { masterNode = it }
}

/** Create a [MasterDetailPane] with initialization block. */
inline fun masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@LayoutDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane = KtfxMasterDetailPane(side, showDetail).apply(init)

/** Add a [MasterDetailPane] to this manager. */
fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true
): MasterDetailPane = addNode(ktfx.controlsfx.masterDetailPane(side, showDetail) { })

/** Add a [MasterDetailPane] with initialization block to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@LayoutDslMarker KtfxMasterDetailPane).() -> Unit
): MasterDetailPane = addNode(ktfx.controlsfx.masterDetailPane(side, showDetail, init))

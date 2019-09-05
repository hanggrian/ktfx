@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {

    override fun <T : Node> T.add(): T = also { masterNode = it }
}

/** Add a [MasterDetailPane] to this manager. */
fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true
): MasterDetailPane = _MasterDetailPane(side, showDetail).add()

/** Add a [MasterDetailPane] with initialization block to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: (@LayoutDslMarker _MasterDetailPane).() -> Unit
): MasterDetailPane = (masterDetailPane(side, showDetail) as _MasterDetailPane).apply(init)

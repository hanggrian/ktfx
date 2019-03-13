@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {

    override fun <T : Node> T.add(): T = also { masterNode = it }
}

/** Creates a [MasterDetailPane]. */
fun masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: ((@LayoutDslMarker _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = _MasterDetailPane(side, showDetail).also { init?.invoke(it) }

/** Creates a [MasterDetailPane] and add it to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutDslMarker _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = ktfx.controlsfx.masterDetailPane(side, showDetail, init).add()
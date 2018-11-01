@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.geometry.Side.RIGHT
import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeManager {

    override fun <T : Node> T.invoke(): T = also {
        when (null) {
            masterNode -> masterNode = it
            detailNode -> detailNode = it
            else -> error("MasterDetailPane may only have 2 children")
        }
    }
}

/** Creates a [MasterDetailPane]. */
fun masterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true,
    init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = _MasterDetailPane(side, showDetail).also { init?.invoke(it) }

/** Creates a [MasterDetailPane] and add it to this manager. */
inline fun NodeManager.masterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = ktfx.controlsfx.masterDetailPane(side, showDetail, init)()
@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.geometry.Side
import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeInvokable
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(side: Side, showDetail: Boolean) : MasterDetailPane(side, showDetail), NodeInvokable {

    override fun <T : Node> T.invoke(): T = also { masterNode = it }
}

/** Creates a [MasterDetailPane]. */
fun masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    init: ((@LayoutMarker _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = _MasterDetailPane(side, showDetail).also { init?.invoke(it) }

/** Creates a [MasterDetailPane] and add it to this manager. */
inline fun NodeInvokable.masterDetailPane(
    side: Side = Side.RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutMarker _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = ktfx.controlsfx.masterDetailPane(side, showDetail, init)()
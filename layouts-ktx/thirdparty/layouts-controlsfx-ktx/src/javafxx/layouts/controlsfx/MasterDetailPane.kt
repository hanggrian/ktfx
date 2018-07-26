@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts.controlsfx

import javafx.geometry.Side
import javafx.geometry.Side.RIGHT
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.MasterDetailPane

open class _MasterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true
) : MasterDetailPane(side, showDetail), LayoutManager<Node> {

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
): MasterDetailPane = _MasterDetailPane(side, showDetail).also {
    init?.invoke(it)
}

/** Creates a [MasterDetailPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.masterDetailPane(
    side: Side = RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = javafxx.layouts.controlsfx.masterDetailPane(side, showDetail, init = init)()

/** Create a styled [MasterDetailPane]. */
fun styledMasterDetailPane(
    styleClass: String,
    side: Side = RIGHT,
    showDetail: Boolean = true,
    init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = _MasterDetailPane(side, showDetail).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MasterDetailPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMasterDetailPane(
    styleClass: String,
    side: Side = RIGHT,
    showDetail: Boolean = true,
    noinline init: ((@LayoutDsl _MasterDetailPane).() -> Unit)? = null
): MasterDetailPane = javafxx.layouts.controlsfx.styledMasterDetailPane(styleClass, side, showDetail, init = init)()
@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.layouts

import javafx.scene.control.TreeItem
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.BreadCrumbBar

/** Create a [BreadCrumbBar] with initialization block. */
inline fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> = BreadCrumbBar(selectedCrumb).apply(init)

/** Add a [BreadCrumbBar] to this manager. */
fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null
): BreadCrumbBar<T> = addNode(BreadCrumbBar(selectedCrumb))

/** Add a [BreadCrumbBar] with initialization block to this manager. */
inline fun <T> NodeManager.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: (@LayoutDslMarker BreadCrumbBar<T>).() -> Unit
): BreadCrumbBar<T> = addNode(BreadCrumbBar(selectedCrumb), init)

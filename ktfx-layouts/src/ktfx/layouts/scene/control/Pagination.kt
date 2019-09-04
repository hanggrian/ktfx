@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Pagination

/** Add a [Pagination] to this manager. */
fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0
): Pagination = Pagination(count, index).add()

/** Add a [Pagination] with initialization block to this manager. */
inline fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDslMarker Pagination).() -> Unit
): Pagination = pagination(count, index).apply(init)

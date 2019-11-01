@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.Pagination

/** Create a [Pagination] with initialization block. */
inline fun pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDslMarker Pagination).() -> Unit
): Pagination = Pagination(count, index).apply(init)

/** Add a [Pagination] to this manager. */
fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0
): Pagination = addNode(Pagination(count, index))

/** Add a [Pagination] with initialization block to this manager. */
inline fun NodeManager.pagination(
    count: Int = Pagination.INDETERMINATE,
    index: Int = 0,
    init: (@LayoutDslMarker Pagination).() -> Unit
): Pagination = addNode(Pagination(count, index), init)

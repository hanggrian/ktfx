@file:JvmMultifileClass
@file:JvmName("ColumnKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn

/** DSL marker for table and tree table columns. */
@DslMarker
@Target(AnnotationTarget.TYPE)
annotation class TableColumnDslMarker

/** Interface to build [TableColumn] with Kotlin DSL. */
class TableColumnsBuilder<S> internal constructor(private val columns: MutableCollection<TableColumn<S, *>>) {

    fun <T> column(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: (@TableColumnDslMarker TableColumn<S, T>.() -> Unit)
    ): TableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: (@TableColumnDslMarker TableColumn<S, T>.() -> Unit)
    ): TableColumn<S, T> = column(this, init)
}

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
class TreeTableColumnsBuilder<S> internal constructor(private val columns: MutableCollection<TreeTableColumn<S, *>>) {

    fun <T> column(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: (@TableColumnDslMarker TreeTableColumn<S, T>.() -> Unit)
    ): TreeTableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: (@TableColumnDslMarker TreeTableColumn<S, T>.() -> Unit)
    ): TreeTableColumn<S, T> = column(this, init)
}

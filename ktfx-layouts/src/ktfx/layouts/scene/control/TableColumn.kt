@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Interface to build [TableColumn] with Kotlin DSL. */
sealed class TableColumnsBuilder<S> {

    abstract fun <T> column(
        text: String? = null
    ): TableColumn<S, T>

    inline fun <T> column(
        text: String? = null,
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column(this, init)
}

private class _TableColumnsBuilder<S> : TableColumnsBuilder<S>() {

    val collection: MutableCollection<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { collection += it }
}

/** Invokes a [TableColumn] DSL builder. */
fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).collection
}

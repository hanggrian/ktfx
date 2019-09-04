@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null,
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T>

    operator fun <T> String.invoke(
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T> = column(this, init)
}

internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S>, LayoutManager<TableColumn<S, *>> {

    val collection: MutableCollection<TableColumn<S, *>> = mutableListOf()

    override fun <R : TableColumn<S, *>> R.add(): R = also { collection += it }

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { init?.invoke(it) }.add()
}

/** Invokes a [TableColumn] DSL builder. */
fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).collection
}

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Invokes a [TableColumn] DSL builder. */
fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += TableColumnsBuilderImpl<S>().apply(init).collection
}

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null
    ): TableColumn<S, T>

    fun <T> column(
        text: String? = null,
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column<T>(text).apply(init)

    operator fun <T> String.invoke(
        init: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column(this, init)
}

private class TableColumnsBuilderImpl<S> : TableColumnsBuilder<S> {

    val collection: MutableCollection<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { collection += it }
}

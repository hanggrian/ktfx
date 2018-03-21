@file:Suppress("ClassName")

package ktfx.layouts

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(text: String? = null, init: (TableColumn<S, T>.() -> Unit)? = null)
}

@PublishedApi
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S> {

    val columns: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?) {
        columns += TableColumn<S, T>(text).apply { init?.invoke(this) }
    }
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).columns
}
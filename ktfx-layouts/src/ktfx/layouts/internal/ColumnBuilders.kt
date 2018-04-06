@file:Suppress("ClassName")

package ktfx.layouts.internal

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import ktfx.layouts.TableColumnsBuilder
import ktfx.layouts.TreeTableColumnsBuilder

@PublishedApi
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S> {
    val columns: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: TableColumn<S, T>.() -> Unit): TableColumn<S, T> =
        TableColumn<S, T>(text).apply(init).also { columns += it }
}

@PublishedApi
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S> {
    val columns: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).apply(init).also { columns += it }
}
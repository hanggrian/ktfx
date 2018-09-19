@file:Suppress("ClassName")

package javafxx.layouts

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn

@PublishedApi
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S>, LayoutManager<TableColumn<S, *>> {

    override val childs: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { init?.invoke(it) }()
}

@PublishedApi
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S>, LayoutManager<TreeTableColumn<S, *>> {

    override val childs: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TreeTableColumn<S, T>.() -> Unit)?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { init?.invoke(it) }()
}
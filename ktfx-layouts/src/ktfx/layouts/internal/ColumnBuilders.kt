@file:Suppress("ClassName")

package ktfx.layouts.internal

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import ktfx.layouts.LayoutManager
import ktfx.layouts.TableColumnsBuilder
import ktfx.layouts.TreeTableColumnsBuilder

@PublishedApi
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S>, LayoutManager<TableColumn<S, *>> {

    override val childs: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?): TableColumn<S, T> =
        TableColumn<S, T>(text).also { init?.invoke(it) }.add()
}

@PublishedApi
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S>, LayoutManager<TreeTableColumn<S, *>> {

    override val childs: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TreeTableColumn<S, T>.() -> Unit)?): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { init?.invoke(it) }.add()
}